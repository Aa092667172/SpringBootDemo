package com.ioc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PropertiesPrintTest {
    @Autowired
    private PropertiesPrint propertiesPrint;
    @Test
    public void Test(){
        System.out.println(propertiesPrint.getAmount());
        System.out.println(propertiesPrint.getName());
        System.out.println(propertiesPrint.getCount());
    }
}
