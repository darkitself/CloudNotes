package com.example.demo.web.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreateToDoListRequest {
    @NotBlank
    private String name;
}
