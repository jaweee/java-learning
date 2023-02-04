package com.jaweee;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;

/**
 * @description: TODO
 * @author: jiawei
 * @date: 2023/1/30 08:55
 * @github: https://github.com/jaweee
 * @version: 1.0
 */

@SpringBootTest
public class TutorialsApplicationTests {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Test
    void testRedisString() {
        System.out.println("hello");
        // 1. 自己设置序列化，通过RedisTemplate
        // 这里有一个错误，就是当你不set name的时候，直接get name是不通过没法读取json的
        // redisTemplate.opsForValue().set("name", "");
        // Object name = redisTemplate.opsForValue().get("name");

        // 2. 通过stringRedisTemplate来做
        stringRedisTemplate.opsForValue().set("name", "rose");
        String s = stringRedisTemplate.opsForValue().get("name");
        System.out.println("name = " + s);
    }

}
