package com.ioc;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 取得設定檔案中的
 */
@Component
@Data
public class PropertiesPrint {
    @Value("${printer.name:haha}")
    private String name;
    @Value("${printer.count}")
    private Integer count;
    //:為取得失敗的預設值
    @Value("${printer.amount:1000}")
    private Integer amount;
}
