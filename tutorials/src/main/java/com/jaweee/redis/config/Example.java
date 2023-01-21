package com.jaweee.redis.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.net.URL;

/**
 * @description: TODO
 * @author: jiawei
 * @date: 2023/1/20 11:38
 * @github: https://github.com/jaweee
 * @version: 1.0
 */
public class Example {

    @Autowired
    private RedisTemplate<String, String> template;

    @Resource(name = "redisTemplate")
    private ListOperations<String, String> listOps;

    public void addLink(String userId, URL url){
        listOps.leftPush(userId, url.toExternalForm());
    }
}
