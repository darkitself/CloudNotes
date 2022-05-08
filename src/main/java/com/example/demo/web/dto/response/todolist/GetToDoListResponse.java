package com.example.demo.web.dto.response.todolist;


import com.example.demo.domain.enums.TaskState;
import com.example.demo.domain.enums.UserRole;
import com.example.demo.web.dto.base.NoteDto;
import com.example.demo.web.dto.base.ToDoListDto;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class GetToDoListResponse {
    UserRole role;
    ToDoListDto toDoList;
    List<TaskState> states;
}
