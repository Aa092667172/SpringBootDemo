package com.aop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyAspectTest {
    @Autowired
    Dog dog;
    @Test
    public void aspectDog(){
       dog.eat();
    }
}