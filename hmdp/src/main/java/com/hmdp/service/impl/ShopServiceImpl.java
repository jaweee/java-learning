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
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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
            // 2. 如果数据库查到就直接返回
            shop = BeanUtil.fillBeanWithMap(shopMap, new Shop(), false);
            return Result.ok(shop);
        }
        // 3. 没有查到，就去数据库查询
        shop = query().eq("id", id).one();
        if (shop == null) {
            return Result.fail("404, 店铺不存在");
        }
        // 4. 数据库中查到，就缓存到redis中
        Map<String, Object> map = BeanUtil.beanToMap(shop, new HashMap<>(), CopyOptions.create()
                .setIgnoreNullValue(true)
                .setFieldValueEditor((filedName, filedValue) -> filedValue.toString()));
        stringRedisTemplate.opsForHash().putAll(RedisConstants.CACHE_SHOP_KEY + id, map);
        // 5. 由于查询sql后写redis的时间间隔极小，所以此时很难有其他线程对sql进行修改
        //    即使有，我们可以设置redis有效时间，是下一次缓存不命中的时候查询sql
        stringRedisTemplate.expire(RedisConstants.CACHE_SHOP_KEY, RedisConstants.CACHE_SHOP_TTL ,TimeUnit.MINUTES);
        return Result.ok(shop);

    }

    /**
     * 在单体项目中使用transaction来保证更新数据库和删除缓存是原子操作
     * @param shop
     * @return
     */
    @Override
    @Transactional
    public Result updateCacheShop(Shop shop) {
        Long id = shop.getId();
        if (id == null) {
            return Result.fail("店铺id不能为空");
        }
        // 1. 更新数据
        updateById(shop);
        // 2. 删除缓存
        stringRedisTemplate.delete(RedisConstants.CACHE_SHOP_KEY + id);
        return Result.ok();
    }
}
