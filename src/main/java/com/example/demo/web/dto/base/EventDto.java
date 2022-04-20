package com.example.demo.web.dto.base;

import lombok.Data;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Data
public class EventDto {
    private String name;
    private Instant date;

    private Set<UserDto> users = new HashSet<>();

    private Set<NoteDto> notes = new HashSet<>();

    private Set<ToDoListDto> toDoLists = new HashSet<>();
}
