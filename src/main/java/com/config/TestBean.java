package com.config;

import lombok.Data;
import lombok.ToString;

/**
 *
 * 可放@Component 將class放入ioc容器中,但@Component只能用於類
 */
@Data
@ToString
public class TestBean {
    private String valueA;
    private Integer valueB;
}
