package com.example.demo.web.dto.base;

import com.example.demo.domain.entity.Event;
import com.example.demo.web.dto.base.shorten.ShortEventDto;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class EventDto {
    Long id;
    String name;
    Instant date;

    Set<UserDto> users = new HashSet<>();

    Set<NoteDto> notes = new HashSet<>();

    Set<ToDoListDto> toDoLists = new HashSet<>();

    public static EventDto from(Event event) {
        return new EventDto(
                event.getId(),
                event.getName(),
                event.getDate()
        );
    }
}
