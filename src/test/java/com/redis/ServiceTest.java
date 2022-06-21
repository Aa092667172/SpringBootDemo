package com.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ServiceTest {
    @Autowired
    private RedisTemplate redisTemplate;


    @Test
    void put() {
        redisTemplate.opsForValue().set("haha","test");
    }

    @Test
    void get() {
        String haha =(String) redisTemplate.opsForValue().get("haha");
        assertEquals("test",haha);
    }
}