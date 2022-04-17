package com.controller;

import com.entity.Student;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;

@RestController
@Validated
public class StudentController {
    @PostMapping("/students")
    public String create(@RequestBody @Valid Student student){
        return "執行create";
    }
    @GetMapping("/students/{studentId}")
    public String read(@PathVariable  @Max(5) Integer studentId){
        return "read";
    }
    @PutMapping("/students/{studentId}")
    public String update(@PathVariable Integer studentId,
                         @RequestBody Student student){
        return "update";
    }
    @DeleteMapping("/students/{studentId}")
    public String delete(@PathVariable Integer studentId){
        return "delete";
    }
}
