package com.example.demo.web.dto.request.event;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class GetEventRequest {
    @NonNull Long eventId;
}
