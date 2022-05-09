package com.example.demo.web.dto.response.export;

import com.example.demo.domain.entity.Note;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ExportNote {
    String name;
    String note;

    public static ExportNote from(Note note) {
        return new ExportNote(
                note.getName(),
                note.getNote()
        );
    }
}
