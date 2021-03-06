package com.springjdbc;

import com.model.Book;
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
public class BookResultSetExtractor implements ResultSetExtractor<List<Book>> {
    @Override
    public List<Book> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<Book> result = new ArrayList<>();
        while (rs.next()){
            Book book = new Book();
            book.setId(rs.getLong("id"));
            book.setName(rs.getString("name"));
            result.add(book);
        }
        return result;
    }
}
