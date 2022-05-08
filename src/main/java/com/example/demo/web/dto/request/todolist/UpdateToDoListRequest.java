package com.example.demo.web.dto.request.todolist;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;
import java.util.LinkedList;
import java.util.List;

@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UpdateToDoListRequest {
    @NotBlank String name;
    List<UpdateTaskRequest> tasks = new LinkedList<>();
}
