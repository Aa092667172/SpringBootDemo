package com.config.properties;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyPropertiesTest {
    @Autowired
    MyProperties printBean;
    @Test
    void print(){
        System.out.println(printBean);
    }
}