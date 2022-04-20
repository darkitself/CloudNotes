package com.example.demo.web.dto.request.event;

import lombok.Data;
import lombok.NonNull;

@Data
public class GetEventRequest {
    @NonNull
    private Long eventId;
}
