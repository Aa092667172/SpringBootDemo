package com.mybatis.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookMapperTest {
    @Autowired
    private BookMapper mapper;
    @Test
    void insert(){
        mapper.insert("哈哈");
    }
}