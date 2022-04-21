package com.service;

import com.dao.BookDao;
import com.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;
    @Override
    public Book getById(Long bookId) {
        return bookDao.getById(bookId);
    }
}
