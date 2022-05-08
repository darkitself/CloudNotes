package com.example.demo.web.dto.base.shorten;

import com.example.demo.domain.entity.Note;
import com.example.demo.domain.entity.ToDoList;
import com.example.demo.domain.enums.UserRole;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ShortToDoListDto {
    Long id;
    String name;
    UserRole role;

    public static ShortToDoListDto from(ToDoList toDoList, UserRole role) {
        return new ShortToDoListDto(toDoList.getId(), toDoList.getName(), role);
    }
}
