package com.example.demo.web.dto.response.event;

import com.example.demo.web.dto.base.shorten.ShortEventDto;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class GetUserEventsResponse {
    List<ShortEventDto> userEvents;
}