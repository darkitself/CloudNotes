package com.example.demo.service.impl;

import com.example.demo.domain.entity.Event;
import com.example.demo.domain.entity.User;
import com.example.demo.domain.entity.UserEvent;
import com.example.demo.domain.enums.UserRole;
import com.example.demo.domain.repository.EventRepository;
import com.example.demo.domain.repository.UserEventRepository;
import com.example.demo.service.EventsService;
import com.example.demo.service.PrincipalService;
import com.example.demo.web.dto.request.event.CreateEventRequest;
import com.example.demo.web.dto.request.event.DeleteEventRequest;
import com.example.demo.web.dto.request.event.GetEventRequest;
import com.example.demo.web.dto.request.event.UpdateEventRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class EventsServiceImpl implements EventsService {

    EventRepository eventRepository;
    PrincipalService principalService;
    UserEventRepository userEventRepository;

    @Override
    public Event create(CreateEventRequest request) {
        Event event = Event.createFrom(request);
        User user = principalService.getUser();
        UserEvent userEvent = new UserEvent(user, event, UserRole.OWNER);
        event.getUsers().add(userEvent);
        return eventRepository.save(event);
    }

    @Override
    public Event getEvent(GetEventRequest request) {
        User user = principalService.getUser();
        Optional<UserEvent> userEvent = userEventRepository.findByEventIdAndUser(request.getEventId(), user);
        if (userEvent.isEmpty() || !userEvent.get().getRole().canView())
            return null;
        return userEvent.get().getEvent();
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Event update(UpdateEventRequest request) {
        Event event = eventRepository.getById(request.getEventId());
        event.updateFrom(request);
        return eventRepository.save(event);
    }

    @Override
    public void delete(DeleteEventRequest request) {
        eventRepository.deleteById(request.getEventId());
    }
}
