package com.aop;

import org.springframework.stereotype.Component;

@Component
public class Dog {

    public void eat(){
        System.out.println("啃骨頭");
    }
}
