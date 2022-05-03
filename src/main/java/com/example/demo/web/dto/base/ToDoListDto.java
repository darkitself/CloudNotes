package com.example.demo.web.dto.base;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ToDoListDto {
    String name;

    List<TaskDto> tasks = new LinkedList<>();

    Set<UserDto> users = new HashSet<>();
}
