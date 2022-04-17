package com.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 當Ioc容器中有多個相同類型Bean
 * 需加入Qualifier指定bean名稱
 * 預設Bean名稱為class首字母小寫
 */
@RestController
public class MyController {
    @Autowired
    @Qualifier("myPrinter")
    private Printer printer;

    @Autowired
    @Qualifier("testPrinter")
    private Printer printer1;

    @RequestMapping("/testIoc")
    public String test(){
        printer.print("Hello World");
        printer1.print("嗨嗨");
        return "Hello world!";
    }
}
