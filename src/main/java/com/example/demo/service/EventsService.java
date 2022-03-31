package com.example.demo.service;

import com.example.demo.domain.entity.Event;
import com.example.demo.web.dto.EventRequest;

public interface EventsService {
    Event create(EventRequest request);
}
