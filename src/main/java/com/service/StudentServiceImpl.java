package com.service;

import com.dao.StudentDao;
import com.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentDao studentDao;
    @Override
    public Student getById(Long studentId) {
        return studentDao.getById(studentId);
    }
}
