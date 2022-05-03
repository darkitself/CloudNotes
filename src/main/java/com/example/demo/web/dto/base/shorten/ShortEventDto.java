package com.example.demo.web.dto.base.shorten;

import com.example.demo.domain.entity.Event;
import com.example.demo.domain.enums.UserRole;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ShortEventDto {
    Long eventId;
    String name;
    Instant date;
    UserRole role;

    public static ShortEventDto from(Event event, UserRole role) {
        return new ShortEventDto(event.getId(), event.getName(), event.getDate(), role);
    }
}
