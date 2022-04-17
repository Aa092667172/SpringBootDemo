package com.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class Student {
    private Long id;
    @NotBlank
    private String name;
}
