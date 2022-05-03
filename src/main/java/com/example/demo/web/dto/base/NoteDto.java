package com.example.demo.web.dto.base;

import com.example.demo.domain.entity.Note;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.HashSet;
import java.util.Set;

@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class NoteDto {
    Long id;
    String name;
    String note;

    Set<UserDto> users = new HashSet<>();

    public static NoteDto from(Note note) {
        return new NoteDto(
                note.getId(),
                note.getName(),
                note.getNote()
        );
    }
}
