package com.controller;

import com.entity.Student;
import com.service.StudentService;
import com.springjdbc.StudentRowMapper;
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
public class StudentController {
    @Autowired
    private StudentService studentService;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public StudentController( @Qualifier("gogo") NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
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
    public Student selectOne(@PathVariable Long studentId) {
        return studentService.getById(studentId);
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
