package com.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class Service {
    @Autowired
    private RedisTemplate redisTemplate;

    public void put(String name,Object value){
        redisTemplate.opsForValue().set("haha",123);
    }

    public Object get(String name){
        return redisTemplate.opsForValue().get(name);
    }
}
