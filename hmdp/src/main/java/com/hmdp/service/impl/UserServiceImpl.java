package com.hmdp.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmdp.dto.LoginFormDTO;
import com.hmdp.dto.Result;
import com.hmdp.entity.User;
import com.hmdp.mapper.UserMapper;
import com.hmdp.service.IUserService;
import com.hmdp.utils.RegexUtils;
import com.hmdp.utils.SystemConstants;
import com.hmdp.utils.UserHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

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

    @Override
    public Result sendCode(String phone, HttpSession session) {
        // 1. 校验手机号
        if (!RegexUtils.isPhoneInvalid(phone)) {
            // 2. 如果不符合，返回错误
            return Result.fail("手机号格式错误");
        }
        // 3. 符合，则生成验证码
        String code = RandomUtil.randomNumbers(6);
        // 4. 保存验证码到session
        session.setAttribute("code", code);
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
        // 2. 校验验证码
        String lcode = loginForm.getCode();
        Object scode = session.getAttribute("code");
        if (lcode == null || !scode.toString().equals(lcode)){
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
        session.setAttribute("user", user);
        return null;
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
