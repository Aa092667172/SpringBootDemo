package com.controller;

import com.model.Book;
import com.service.BookService;
import com.springjdbc.BookRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@Validated
public class BookController {
    @Autowired
    private BookService bookService;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public BookController(@Qualifier("gogo") NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @PostMapping("/books")
    public String create(@RequestBody Book book) {
        String insertSql = "insert into book(name) values(:name)";
        Map<String,Object> map = new HashMap<>();
        map.put("name",book.getName());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(insertSql,new MapSqlParameterSource(map),keyHolder);
        long id = Objects.requireNonNull(keyHolder.getKey()).longValue();
        System.out.println(id);
        return "執行create";
    }

    @PostMapping("/books/list")
    public String insertList(@RequestBody List<Book> list){
        String sql = "insert into book(name) values(:bookName)";
        MapSqlParameterSource[] parameterSources = new MapSqlParameterSource[list.size()];
        for(int i=0; i<list.size();i++){
            Book book = list.get(i);
            parameterSources[i] = new MapSqlParameterSource();
            parameterSources[i].addValue("bookName",book.getName());
        }
        namedParameterJdbcTemplate.batchUpdate(sql,parameterSources);
        return "執行一批 insert sql";
    }



    @GetMapping("/books")
    public List<Book> selectList() {
        String sql = "select id,name from book ";
        Map<String,Object> map = new HashMap<>();
        return namedParameterJdbcTemplate.query(sql, map, new BookRowMapper());
    }

    @GetMapping("/books/{bookId}")
    public Book selectOne(@PathVariable Long bookId) {
        return bookService.getById(bookId);
    }



    @PutMapping("/books/{bookId}")
    public String update(@PathVariable Integer bookId,
                         @RequestBody Book book) {
        String sql = "update book set name = :name where id = :id ";
        Map<String,Object> map = new HashMap<>();
        map.put("id",bookId);
        map.put("name",book.getName());
        namedParameterJdbcTemplate.update(sql,map);
        return "update";
    }

    @DeleteMapping("/books/{bookId}")
    public String delete(@PathVariable Integer bookId) {
        String sql =  "delete from book where id = :id ";
        Map<String,Object> map = new HashMap<>();
        map.put("id",bookId);
        namedParameterJdbcTemplate.update(sql,map);
        return "delete";
    }

}
