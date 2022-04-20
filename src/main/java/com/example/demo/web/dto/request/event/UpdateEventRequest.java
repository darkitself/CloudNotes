package com.example.demo.web.dto.request.event;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotBlank;

@Data
public class UpdateEventRequest {
    @NonNull
    private Long eventId;
    @NotBlank
    private String name;
    @NotBlank
    private String date;
}
