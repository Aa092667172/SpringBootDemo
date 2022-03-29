package com.employee.test;

import com.entity.Employee;
import com.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmployeeTest {
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

}