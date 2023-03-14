package com.hmdp.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmdp.dto.LoginFormDTO;
import com.hmdp.dto.Result;
import com.hmdp.dto.UserDTO;
import com.hmdp.entity.User;
import com.hmdp.mapper.UserMapper;
import com.hmdp.service.IUserService;
import com.hmdp.utils.RedisConstants;
import com.hmdp.utils.RegexUtils;
import com.hmdp.utils.SystemConstants;
import com.hmdp.utils.UserHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 虎哥
 * @since 2021-12-22
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    StringRedisTemplate stringRedisTemplate;

    /**
     * 发送验证码，
     * @param phone
     * @param session
     * @return
     */
    @Override
    public Result sendCode(String phone, HttpSession session) {
        // 1. 校验手机号
        if (!RegexUtils.isPhoneInvalid(phone)) {
            // 2. 如果不符合，返回错误
            return Result.fail("手机号格式错误");
        }

        // 3. 符合，则生成验证码
        String code = RandomUtil.randomNumbers(6);

        // 4. 保存验证码到session，修改到用redis保存
        // session.setAttribute("code", code);
        // 将手机号和验证码存到redis中，让验证码保存两分钟
        stringRedisTemplate.opsForValue().set(RedisConstants.LOGIN_CODE_KEY + phone, code, RedisConstants.LOGIN_CODE_TTL, TimeUnit.MINUTES);

        // 5. 发送验证码
        log.debug("发送短信验证码成功，验证码：{}", code);
        // 返回ok
        return Result.ok();
    }

    @Override
    public Result login(LoginFormDTO loginForm, HttpSession session) {
        String phone = loginForm.getPhone();
        // 1. 校验手机号
        if (!RegexUtils.isPhoneInvalid(phone)) {
            return Result.fail("手机号校验不对");
        }
        // 2. 校验验证码，从登录表单中获取验证码和redis中缓存的验证码进行校验
        String formCode = loginForm.getCode();
        // Object scode = session.getAttribute("code");
        String cacheCode = stringRedisTemplate.opsForValue().get(RedisConstants.LOGIN_CODE_KEY + phone);
        if (formCode == null || cacheCode == null || !cacheCode.equals(formCode)){
            // 3. 不一致返回
            return Result.fail("验证码校验不对");
        }
        // 4. 一致的话就去数据库中查询
        User user = query().eq("phone", phone).one();
        if (user == null) {
            // 5. 不存在，创建新用户，
            user = createUserWithPhone(phone);
        }
        // 6. 将用户存入session
        // session.setAttribute("user", BeanUtil.copyProperties(user, UserDTO.class));
        // 6. 更新为，这里以随机token为key，存储用户数据，
        String token = UUID.randomUUID().toString(true);
        UserDTO userDTO = BeanUtil.copyProperties(user, UserDTO.class);
        Map<String, Object> map = BeanUtil.beanToMap(userDTO, new HashMap<>(),
                CopyOptions.create()
                        .setIgnoreNullValue(true)
                        .setFieldValueEditor((fieldName, fieldValue) -> fieldValue.toString()));
        // 这里就是为了，替换从threadlocal中获取值，而是在redis获取用户，并且在拦截器中更新存活时间，想session一样
        String tokenKey = RedisConstants.LOGIN_USER_KEY + token;
        stringRedisTemplate.opsForHash().putAll(tokenKey, map);
        stringRedisTemplate.expire(tokenKey, RedisConstants.LOGIN_USER_TTL, TimeUnit.MINUTES);

        return Result.ok(token);
    }

    private User createUserWithPhone(String phone) {
        // 1. 创建用户
        User user = new User();
        user.setPhone(phone);
        user.setNickName(SystemConstants.USER_NICK_NAME_PREFIX + RandomUtil.randomNumbers(10).toString());
        // 2. 保存用户
        save(user);
        return user;
    }
}
