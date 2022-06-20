package com;

import com.config.*;
import com.config.filter.FilterBean;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;


/**
 * 根據官網文件靜態資源目錄   /static  or /public or /resources/  or META-INF/resources
 * 預設掃描當前包中的類,為com pakeage.
 * SpringBootApplication為複合式註解 相當於
 * @SpringBootConfiguration
 * @EnableAutoConfiguration
 * @ComponentScan(excludeFilters = { @Filter(type = FilterType.CUSTOM, classes = TypeExcludeFilter.class),
 *                @Filter(type = FilterType.CUSTOM, classes = AutoConfigurationExcludeFilter.class) })
 */
//@SpringBootApplication
public class StudyApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext run = SpringApplication.run(StudyApplication.class, args);
        //兩種寫法
        TestBean beanByClass = run.getBean(TestBean.class);
        //加上了Configuration的物件也將會是一個Bean
        ConfigTestBean configTestBean = run.getBean(ConfigTestBean.class);
        TestBean bean = (TestBean) run.getBean("testBean");
        TestBean1 bean1 = (TestBean1) run.getBean("testBean1");
        try{
            run.getBean(FilterBean.class);
            System.out.println("FilterBean加入ioc容器中");
        }catch (Exception e){
            System.out.println("FilterBean被過濾掉了");
        }
        ConfigOn  test = run.getBean(ConfigOn.class);
        System.out.println(beanByClass);
        System.out.println(bean);
        System.out.println(bean1);
        System.out.println(configTestBean);
        //透過xml設置
        System.out.println(run.getBean(ConfigTestBeanXML.class));
        //透過import設置
        System.out.println(run.getBean(ImportBean.class));

    }

}