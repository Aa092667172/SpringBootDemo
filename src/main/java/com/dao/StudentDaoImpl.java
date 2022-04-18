package com.dao;

import com.entity.Student;
import com.springjdbc.StudentRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class StudentDaoImpl implements StudentDao{
    @Autowired
    @Qualifier("gogo")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Student getById(Long studentId) {
        String sql = "select id,name from student where id = :id ";
        Map<String,Object> map = new HashMap<>();
        map.put("id",studentId);
        List<Student> list = namedParameterJdbcTemplate.query(sql, map, new StudentRowMapper());
//        List<Student> list = namedParameterJdbcTemplate.query(sql, map, new StudentResultSetExtractor());
        return list.stream().findFirst().orElseGet(Student::new);
    }
}
