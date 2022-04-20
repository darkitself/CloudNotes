package com.example.demo.web.dto.request.event;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreateEventRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String date;
}
