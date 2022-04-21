package com.controller;

import com.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
@RestController
public class DataSourceController {
    @Autowired
    @Qualifier("gogo")
    private NamedParameterJdbcTemplate gogo;
    @Autowired
    @Qualifier("webApp")
    private NamedParameterJdbcTemplate webApp;

    @PostMapping("/insert/gogo")
    public String gogoInsert(@RequestBody Book book){
        String sql = "insert into student(name) values (:bookName)";
        Map<String,Object> map = new HashMap<>();
        map.put("bookName",book.getName());
        gogo.update(sql,map);
        return "insert 進入gogo";
    }

    @PostMapping("/insert/webApp")
    public String webAppInsert(@RequestBody Book book){
        String sql = "insert into student(name) values (:bookName)";
        Map<String,Object> map = new HashMap<>();
        map.put("bookName",book.getName());
        webApp.update(sql,map);
        return "insert 進入webApp";
    }
}
