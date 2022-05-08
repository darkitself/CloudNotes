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

    public static ShortNoteDto from(Note note) {
        return new ShortNoteDto(note.getId(), note.getName());
    }
}