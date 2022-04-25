package com.dao;

import com.model.Student;

import java.util.List;

public interface StudentDao {

    Integer insert(Student student);

    void update(Student student);

    void deleteById(Integer id);

    Student getById(Integer id);

    List<Student> findAll();
}
