package com.example.demo.web.dto.base;

import com.example.demo.domain.entity.ToDoList;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ToDoListDto {
    Long id;
    String name;

    List<TaskDto> tasks;

    Set<UserDto> users = new HashSet<>();

    public static ToDoListDto from(ToDoList toDoList) {
        return new ToDoListDto(
                toDoList.getId(),
                toDoList.getName(),
                toDoList.getTasks().values().stream()
                        .map(TaskDto::from)
                        .collect(Collectors.toList())
        );
    }
}
