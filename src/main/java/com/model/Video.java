package com.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Video {
    private Long id;
    private String name;
    @JsonProperty("content_number")
    private Integer number;
}
