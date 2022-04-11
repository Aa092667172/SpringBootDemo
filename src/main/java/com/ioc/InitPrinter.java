package com.ioc;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * 實作InitializingBean可達成初始化Bean
 * 但多數使用＠PostConstruct,因較簡易
 */
@Component
public class InitPrinter implements Printer, InitializingBean {
    private int count;

    @Override
    public void print(String message) {
        count--;
        System.out.println("剩餘使用次數"+count);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        count = 5;
    }
}
