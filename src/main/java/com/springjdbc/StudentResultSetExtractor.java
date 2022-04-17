package com.springjdbc;

import com.entity.Student;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * StudentResultSetExtractor與傳統JDBC較相似 與RowMapper差別在於
 * 寫法以及RowMapper只能取得當前Row的資訊
 */
public class StudentResultSetExtractor implements ResultSetExtractor<List<Student>> {
    @Override
    public List<Student> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<Student> result = new ArrayList<>();
        while (rs.next()){
            Student student = new Student();
            student.setId(rs.getLong("id"));
            student.setName(rs.getString("name"));
            result.add(student);
        }
        return result;
    }
}
