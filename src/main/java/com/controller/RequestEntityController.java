package com.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestEntityController {
    @RequestMapping("/test")
    public ResponseEntity<String> test(){
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Hello World");
    }
    @RequestMapping("/test1")
    public String test1(){
        throw  new RuntimeException("test1 error");
    }

    @RequestMapping("/test2")
    public String test2(){
        throw  new IllegalArgumentException("test2 error");
    }
}
