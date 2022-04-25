package com.employee;

import com.model.Employee;
import com.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmployeeTest {
    @Autowired
    private EmployeeRepository repository;

    @Test
    public void save() {
        Employee vo = new Employee();
        vo.setAge(20);
        vo.setEmail("qqp15601560@yahoo.com.tw");
        vo.setName("yoyo");
        Employee employee = repository.save(vo);
        System.out.println(employee);
    }

    @Test
    public void findAll() {
        System.out.println(repository.findAll());
    }

    @Test
    public void testQuery(){
        System.out.println(repository.testQuery("yoyo",1l));
    }
}