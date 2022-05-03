package com.example.demo.web.dto.response.note;

import com.example.demo.web.dto.base.shorten.ShortNoteDto;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class GetUserNotesResponse {
    List<ShortNoteDto> userNotes;
}