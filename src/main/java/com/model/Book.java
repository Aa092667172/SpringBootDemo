package com.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class Book {
    private Long id;
    @NotBlank
    private String name;
}
