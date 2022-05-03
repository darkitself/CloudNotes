package com.example.demo.web.dto.response.note;


import com.example.demo.domain.enums.UserRole;
import com.example.demo.web.dto.base.NoteDto;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class GetNoteResponse {
    UserRole role;
    NoteDto note;
}
