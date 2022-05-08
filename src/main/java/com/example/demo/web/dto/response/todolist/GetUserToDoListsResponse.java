package com.example.demo.web.dto.response.todolist;

import com.example.demo.web.dto.base.shorten.ShortNoteDto;
import com.example.demo.web.dto.base.shorten.ShortToDoListDto;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class GetUserToDoListsResponse {
    List<ShortToDoListDto> userToDoLists;
}