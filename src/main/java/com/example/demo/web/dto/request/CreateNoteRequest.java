package com.example.demo.web.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreateNoteRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String note;
    private Long eventId;
}
