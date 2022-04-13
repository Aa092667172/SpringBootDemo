package com.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AopController {
    @Autowired
    private Dog dog;
    @RequestMapping("/testAop")
    public String test(){
        dog.eat();
        return "Hello world!";
    }
}
