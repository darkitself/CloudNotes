package com.example.demo.web.dto.base;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class NoteDto {
    private String name;
    private String note;

    private Set<UserDto> users = new HashSet<>();
}
