package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration會使spring Boot偵測到該class
 * @Bean將容器放入ioc容器中 預設名稱為方法名稱
 * 前提是Configuration類需在SpringBootDemoApplication同包中或底下,
 * 或著
 * SpringBootDemoApplication類有加上Scan註解去做掃瞄
 *
 * proxyBeanMethods 預設true 將會進行代理,false為非代理
 *
 * 也可於靜態資源中配置 參考resources/META-INF/
 */
@Configuration
public class ConfigTestBean {
    @Bean
    public TestBean testBean(){
        TestBean testBean = new TestBean();
        testBean.setValueA("1111");
        testBean.setValueB(555);
        return testBean;
    }

}
