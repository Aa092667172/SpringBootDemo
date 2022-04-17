package com.controller;

import com.entity.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springjdbc.StudentRowMapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@Validated
public class StudentController {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public StudentController(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @PostMapping("/students")
    public String create(@RequestBody Student student) {
        String insertSql = "insert into student(name) values(:name)";
        Map<String,Object> map = new HashMap<>();
        map.put("name",student.getName());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(insertSql,new MapSqlParameterSource(map),keyHolder);
        long id = Objects.requireNonNull(keyHolder.getKey()).longValue();
        System.out.println(id);
        return "執行create";
    }

    @PostMapping("/students/list")
    public String insertList(@RequestBody List<Student> list){
        String sql = "insert into student(name) values(:studentName)";
        MapSqlParameterSource[] parameterSources = new MapSqlParameterSource[list.size()];
        for(int i=0; i<list.size();i++){
            Student student = list.get(i);
            parameterSources[i] = new MapSqlParameterSource();
            parameterSources[i].addValue("studentName",student.getName());
        }
        namedParameterJdbcTemplate.batchUpdate(sql,parameterSources);
        return "執行一批 insert sql";
    }

    @GetMapping("/students")
    public List<Student> selectList() {
        String sql = "select id,name from student ";
        Map<String,Object> map = new HashMap<>();
        return namedParameterJdbcTemplate.query(sql, map, new StudentRowMapper());
    }

    @GetMapping("/students/{studentId}")
    public ResponseEntity<String> selectOne(@PathVariable Long studentId) {
        String sql = "select id,name from student where id = :id ";
        Map<String,Object> map = new HashMap<>();
        map.put("id",studentId);
        List<Student> list = namedParameterJdbcTemplate.query(sql, map, new StudentRowMapper());
//        List<Student> list = namedParameterJdbcTemplate.query(sql, map, new StudentResultSetExtractor());
        return list.stream()
                .findFirst()
                .map(value -> {
                    try {
                        return ResponseEntity.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(new ObjectMapper().writeValueAsString(value));
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e);
                    }
                })
                .orElseGet(() -> ResponseEntity.badRequest().body("查無此Id資料"));

    }

    @PutMapping("/students/{studentId}")
    public String update(@PathVariable Integer studentId,
                         @RequestBody Student student) {
        String sql = "update student set name = :name where id = :id ";
        Map<String,Object> map = new HashMap<>();
        map.put("id",studentId);
        map.put("name",student.getName());
        namedParameterJdbcTemplate.update(sql,map);
        return "update";
    }

    @DeleteMapping("/students/{studentId}")
    public String delete(@PathVariable Integer studentId) {
        String sql =  "delete from student where id = :id ";
        Map<String,Object> map = new HashMap<>();
        map.put("id",studentId);
        namedParameterJdbcTemplate.update(sql,map);
        return "delete";
    }

}
