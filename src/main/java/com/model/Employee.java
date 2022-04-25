package com.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@DynamicUpdate
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String  name;
    private Integer age;
    @JsonProperty("testEmail")
    private String email;

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper map = new ObjectMapper();
        Employee employee = new Employee();
        employee.setAge(123);
        System.out.println(map.writeValueAsString(employee));
    }

}