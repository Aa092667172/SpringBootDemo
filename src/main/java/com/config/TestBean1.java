package com.config;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Data
@ToString
public class TestBean1 {
    private String valueA;
    private Integer valueB;
}
