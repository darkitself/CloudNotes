package com.example.demo.web.dto.request.note;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;

@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CreateNoteRequest {
    String name;
    String note;
    Long eventId;
}
