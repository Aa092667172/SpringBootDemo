package com.ioc;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class TestPrinter implements Printer{

    private int count;

    /**
     * PostConstruct註解初始化bean
     * 需為公開無回傳無參方法,名稱可隨意取
     */
    @PostConstruct
    public void init(){
        count = 5;
    }

    @Override
    public void print(String message) {
        count--;
        System.out.println("Test印表機:"+message);
        System.out.println("剩餘使用次數"+count);
    }
}
