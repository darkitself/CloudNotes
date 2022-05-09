package com.example.demo.web.dto.response.export;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ExportDto {
    String login;
    List<ExportToDoList> toDoLists;
    List<ExportNote> notes;
}
