package com.example.demo.web.dto.base.shorten;

import com.example.demo.domain.entity.Note;
import com.example.demo.domain.enums.UserRole;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ShortNoteDto {
    Long id;
    String name;
    UserRole role;

    public static ShortNoteDto from(Note note, UserRole role) {
        return new ShortNoteDto(note.getId(), note.getName(), role);
    }
}