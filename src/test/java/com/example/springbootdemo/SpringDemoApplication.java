package com.example.springbootdemo;

import com.entity.Employee;
import com.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootDemoApplicationTests {
    @Autowired
    private EmployeeRepository repository;

    @Test
    public void save() {
        Employee vo = new Employee();
        vo.setAge(20);
        vo.setEmail("test@yahoo.com.tw");
        vo.setName("yoyo");
        repository.save(vo);
    }

    @Test
    public void getOne() {
        Employee vo = new Employee();
        vo.setAge(20);
        vo.setEmail("qqp15601560@yahoo.com.tw");
        vo.setName("yoyo");
        repository.save(vo);
    }

    @Test
    public void getAll() {
        System.out.println(repository.findAll());
    }

}