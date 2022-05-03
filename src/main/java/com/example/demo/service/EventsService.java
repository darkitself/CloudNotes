package com.example.demo.service;

import com.example.demo.domain.entity.Event;
import com.example.demo.web.dto.request.event.CreateEventRequest;
import com.example.demo.web.dto.request.event.DeleteEventRequest;
import com.example.demo.web.dto.request.event.GetEventRequest;
import com.example.demo.web.dto.request.event.UpdateEventRequest;
import com.example.demo.web.dto.response.event.GetEventResponse;
import com.example.demo.web.dto.response.event.GetUserEventsResponse;

import java.util.List;

public interface EventsService {
    Event create(CreateEventRequest request);

    GetEventResponse getEvent(Long eventId);

    GetUserEventsResponse getAllEvents();

    Event update(UpdateEventRequest request);

    void delete(DeleteEventRequest request);
}
