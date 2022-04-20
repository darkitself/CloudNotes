package com.example.demo.web.dto.base;

import lombok.Data;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Data
public class ToDoListDto {
    private String name;

    private List<TaskDto> tasks = new LinkedList<>();

    private Set<UserDto> users = new HashSet<>();
}
