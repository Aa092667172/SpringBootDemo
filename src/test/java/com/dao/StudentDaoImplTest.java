package com.dao;

import com.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Transactional可加於類或方法上
 * 在main底下為中途發生錯誤 rollback
 * 在test底下為測試結束完 rollback
 */
@SpringBootTest
class StudentDaoImplTest {
    @Autowired
    private StudentDao studentDao;
    @Test
    public void getById(){
        Student student = studentDao.getById(6);
        assertNotNull(student);
        assertEquals("Amy",student.getName());
        assertEquals(90.3,student.getScore());
        assertTrue(student.isGraduate());
        assertNotNull(student.getCreateDate());
    }

    @Transactional
    @Test
    public void deleteById(){
        studentDao.deleteById(3);

        Student student = studentDao.getById(3);
        assertNull(student);
    }

    @Test
    @Transactional
    public void insert(){
        Student student = new Student();
        student.setName("kevin");
        student.setScore(66.2);
        student.setGraduate(true);

        Integer studentId = studentDao.insert(student);

        Student result = studentDao.getById(studentId);

        assertNotNull(result);
        assertEquals("kevin",result.getName());
        assertEquals(66.2,result.getScore());
        assertTrue(result.isGraduate());
        assertNotNull(result.getCreateDate());

    }
    @Test
    @Transactional
    public void update(){
        Student student = studentDao.getById(3);
        student.setName("john");

        studentDao.update(student);

        Student result = studentDao.getById(3);

        assertNotNull(result);
        assertEquals("john",result.getName());
    }

}