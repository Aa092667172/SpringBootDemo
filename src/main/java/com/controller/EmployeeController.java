package com.controller;

import com.entity.Employee;
import com.repository.EmployeeRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * RestController = Controller 註解 && 每個方法 ResponseBody
 *
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeRepository repository;
    private boolean aBoolean;

    public EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = "/{id}",produces = MediaType.TEXT_HTML_VALUE)
    public String getOne(@PathVariable Long id) {
        Optional<Employee> byId = repository.findById(id);
        return byId.isPresent()?byId.get().toString():"查無此員工";
    }

    @GetMapping("/")
    public List<Employee> getAll() {
        return repository.findAll();
    }

    @GetMapping("/email")
    public Employee getEmail(@RequestParam String email) {
        return repository.findByEmail(email);
    }

    @GetMapping("/{id}/{name}")
    public Employee testQuery(@PathVariable Long id,
                              @PathVariable String name) {
        return repository.testQuery(name,id);
    }

    @PostMapping("/save")
    public String save(@RequestBody Employee vo) {
        repository.save(vo);
        return "成功";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @RequestBody Employee updateVO) {
        Optional<Employee> employee = repository.findById(id);
        String result;
        if(employee.isPresent()){
            updateVO.setId(id);
            repository.save(updateVO);
            result = "修改成功";
        }else{
            result = "查無此員工";
        }
        return result;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        Optional<Employee> employee = repository.findById(id);
        return employee.map(e -> {
            repository.deleteById(e.getId());
            return "刪除成功";
        }).orElse("查無此員工");
    }
}