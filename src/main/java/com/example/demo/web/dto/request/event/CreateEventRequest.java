package com.example.demo.web.dto.request.event;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;

@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CreateEventRequest {
    @NotBlank String name;
    @NotBlank String date;
}
