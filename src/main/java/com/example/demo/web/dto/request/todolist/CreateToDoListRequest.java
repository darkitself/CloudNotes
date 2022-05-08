package com.example.demo.web.dto.request.todolist;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CreateToDoListRequest {
    String name;
}
