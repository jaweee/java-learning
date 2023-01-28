package com.jaweee.test.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @description: TODO
 * @author: jiawei
 * @date: 2023/1/28 16:48
 * @github: https://github.com/jaweee
 * @version: 1.0
 */

@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;



}
