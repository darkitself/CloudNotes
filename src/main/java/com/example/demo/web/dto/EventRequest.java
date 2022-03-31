package com.example.demo.web.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class EventRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String date;
}
