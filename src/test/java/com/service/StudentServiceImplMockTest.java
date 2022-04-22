package com.service;

import com.dao.StudentDao;
import com.model.Student;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @SpyBean類似 但如沒設定 則使用真實邏輯,因此半真半假
 * @MockBean 則皆為假的Bean
 * 不能mock
 *      static方法
 *      private方法
 *      final class
 */
@SpringBootTest
public class StudentServiceImplMockTest {
    @Autowired
    private StudentService studentService;
    @MockBean
    private StudentDao studentDao;
    @Test
    public void getById(){
        Student mockStudent = new Student();
        mockStudent.setId(100);
        mockStudent.setName("I'm mock");
        //假的bean替換真的bean 兩種寫法相同效果
//        Mockito.when(Mockito.any())
//                .thenReturn(mockStudent);
        Mockito.doReturn(mockStudent)
                .when(studentDao)
                .getById(Mockito.any());
//        模擬拋出例外
//        Mockito.when(studentDao.insert(Mockito.any()))
//                .thenThrow(new RuntimeException());
//        Mockito.doThrow(new RuntimeException()).when(studentDao)
//                .deleteById(Mockito.any());
//      記錄方法使用次數,順序
//        Mockito.verify(studentDao,Mockito.times(2))
//                .getById(2);
        Student student = studentService.getById(3);
        assertNotNull(student);
        assertEquals(100,student.getId());
        assertEquals("I'm mock",student.getName());

    }
}