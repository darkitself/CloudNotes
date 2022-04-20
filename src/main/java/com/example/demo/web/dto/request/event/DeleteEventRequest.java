package com.example.demo.web.dto.request.event;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotBlank;

@Data
public class DeleteEventRequest {
    @NonNull
    private Long eventId;
}