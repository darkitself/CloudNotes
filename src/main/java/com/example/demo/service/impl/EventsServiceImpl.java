package com.example.demo.service.impl;

import com.example.demo.domain.entity.Event;
import com.example.demo.domain.entity.User;
import com.example.demo.domain.entity.UserEvent;
import com.example.demo.domain.repository.EventRepository;
import com.example.demo.service.EventsService;
import com.example.demo.service.PrincipalService;
import com.example.demo.web.dto.EventRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class EventsServiceImpl implements EventsService {
    EventRepository eventRepository;
    PrincipalService principalService;
    @Override
    public Event create(EventRequest request) {
        Event event = new Event(request.getName(), LocalDateTime.parse(request.getDate())
                .toInstant(ZoneOffset.UTC));
        User user = principalService.getUser();
        UserEvent userEvent = new UserEvent(user, event, "OWNER");
        event.getUsers().add(userEvent);
        return eventRepository.save(event);
    }
}
