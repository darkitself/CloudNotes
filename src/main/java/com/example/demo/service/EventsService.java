package com.example.demo.service;

import com.example.demo.domain.entity.Event;
import com.example.demo.web.dto.request.event.CreateEventRequest;
import com.example.demo.web.dto.request.event.DeleteEventRequest;
import com.example.demo.web.dto.request.event.GetEventRequest;
import com.example.demo.web.dto.request.event.UpdateEventRequest;

import java.util.List;

public interface EventsService {
    Event create(CreateEventRequest request);

    Event getEvent(GetEventRequest request);

    List<Event> getAllEvents();

    Event update(UpdateEventRequest request);

    void delete(DeleteEventRequest request);
}
