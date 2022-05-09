package com.example.demo.web.dto.response.export;

import com.example.demo.domain.entity.ToDoList;
import com.example.demo.web.dto.base.TaskDto;
import com.example.demo.web.dto.base.ToDoListDto;
import com.example.demo.web.dto.base.UserDto;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.stream.Collectors;

@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ExportToDoList {
    String name;

    List<ExportTask> tasks;

    public static ExportToDoList from(ToDoList toDoList) {
        return new ExportToDoList(
                toDoList.getName(),
                toDoList.getTasks().values().stream()
                        .map(ExportTask::from)
                        .collect(Collectors.toList())
        );
    }
}
