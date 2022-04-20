package com.example.demo.web.dto.response.event;

import com.example.demo.domain.entity.Event;
import com.example.demo.domain.entity.UserEvent;
import com.example.demo.web.dto.base.EventDto;
import com.example.demo.web.dto.base.UserDto;
import lombok.Data;

import java.util.List;

@Data
public class GetEventResponse {
    EventDto event;
    List<UserDto> userDto;
}
