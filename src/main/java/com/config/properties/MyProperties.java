package com.config.properties;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;



@Data
@ToString
@ConfigurationProperties(prefix = "printerbean")
@Component
public class MyProperties {
    private String name;
    private Integer count;
}
