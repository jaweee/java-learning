package com.hmdp.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.hmdp.dto.Result;
import com.hmdp.entity.Shop;
import com.hmdp.mapper.ShopMapper;
import com.hmdp.service.IShopService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmdp.utils.RedisConstants;
import io.netty.util.internal.StringUtil;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 虎哥
 * @since 2021-12-22
 */
@Service
public class ShopServiceImpl extends ServiceImpl<ShopMapper, Shop> implements IShopService {

    @Resource
    StringRedisTemplate stringRedisTemplate;

    @Override
    public Result queryById(Long id) {
        // 1. 从redis中查询商铺缓存
        Map<Object, Object> shopMap = stringRedisTemplate.opsForHash().entries(RedisConstants.CACHE_SHOP_KEY + id);
        Shop shop = new Shop();
        if (!shopMap.isEmpty()) {
            shop = BeanUtil.fillBeanWithMap(shopMap, new Shop(), false);
            return Result.ok(shop);
        }
        shop = query().eq("id", id).one();
        if (shop == null) {
            return Result.fail("404, 店铺不存在");
        }
        Map<String, Object> map = BeanUtil.beanToMap(shop, new HashMap<>(), CopyOptions.create()
                .setIgnoreNullValue(true)
                .setFieldValueEditor((filedName, filedValue) -> filedValue.toString()));
        stringRedisTemplate.opsForHash().putAll(RedisConstants.CACHE_SHOP_KEY + id, map);
        return Result.ok(shop);

    }
}
