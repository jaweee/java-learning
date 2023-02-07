package com.hmdp.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.hmdp.dto.Result;
import com.hmdp.entity.ShopType;
import com.hmdp.mapper.ShopTypeMapper;
import com.hmdp.service.IShopTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmdp.utils.RedisConstants;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 虎哥
 * @since 2021-12-22
 */
@Service
public class ShopTypeServiceImpl extends ServiceImpl<ShopTypeMapper, ShopType> implements IShopTypeService {

    @Resource
    StringRedisTemplate stringRedisTemplate;

    @Override
    public Result queryList() {
        // 这里做个首页类型缓存
        // 1. 去redis取数据
        // String shopTypeJson = stringRedisTemplate.opsForValue().get(RedisConstants.CACHE_SHOP_TYPE_KEY);
        List<ShopType> shopTypeList = new ArrayList<>();
        List<String> shopStringList = stringRedisTemplate.opsForList().range(RedisConstants.CACHE_SHOP_TYPE_KEY, 0, -1);
        // 2. 如果存在，就直接返回
        if (!shopStringList.isEmpty()) {
            for (String item : shopStringList) {
                shopTypeList.add(JSONUtil.toBean(item, ShopType.class));
            }
            return Result.ok(shopTypeList);
        }
        // 3. 如果不存在，去数据库中查询
        shopTypeList = list();
        if (shopTypeList == null || shopTypeList.isEmpty()) {
            return Result.fail("暂无资源");
        }
        for (ShopType item : shopTypeList) {
            stringRedisTemplate.opsForList().leftPush(RedisConstants.CACHE_SHOP_TYPE_KEY, JSONUtil.toJsonStr(item));
        }
        return Result.ok(shopTypeList);
    }
}
