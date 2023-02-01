package com.jaweee.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

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

    @Test
    public void testString() {
        String s = (String) redisTemplate.opsForValue().get("name");
        System.out.println(s);
    }


}
