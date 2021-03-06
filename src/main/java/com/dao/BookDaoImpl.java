package com.dao;

import com.model.Book;
import com.springjdbc.BookRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class BookDaoImpl implements BookDao {
    @Autowired
    @Qualifier("gogo")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Book getById(Long studentId) {
        String sql = "select id,name from book where id = :id ";
        Map<String,Object> map = new HashMap<>();
        map.put("id",studentId);
        List<Book> list = namedParameterJdbcTemplate.query(sql, map, new BookRowMapper());
//        List<Student> list = namedParameterJdbcTemplate.query(sql, map, new StudentResultSetExtractor());
        return list.stream().findFirst().orElseGet(Book::new);
    }
}
