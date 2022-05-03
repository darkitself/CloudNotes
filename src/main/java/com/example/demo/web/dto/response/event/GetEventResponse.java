package com.example.demo.web.dto.response.event;


import com.example.demo.domain.enums.UserRole;
import com.example.demo.web.dto.base.EventDto;
import com.example.demo.web.dto.base.UserDto;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class GetEventResponse {
    UserRole role;
    EventDto event;
}
