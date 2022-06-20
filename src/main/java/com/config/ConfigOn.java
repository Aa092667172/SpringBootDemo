package com.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.stereotype.Component;

@Component
//ioc容器有才加入
//@ConditionalOnClass(TestBean.class)
@ConditionalOnResource(resources = "file:/Users/linyukai/Desktop/qqq.jpg")
//@ConditionalOnResource(resources = "https://yahoo.com.tw")
public class ConfigOn {

}
