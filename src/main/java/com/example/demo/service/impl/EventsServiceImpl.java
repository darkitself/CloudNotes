package com.example.demo.service.impl;

import com.example.demo.domain.entity.Event;
import com.example.demo.domain.entity.User;
import com.example.demo.domain.entity.UserEvent;
import com.example.demo.domain.enums.UserRole;
import com.example.demo.domain.repository.EventRepository;
import com.example.demo.domain.repository.UserEventRepository;
import com.example.demo.service.EventsService;
import com.example.demo.service.PrincipalService;
import com.example.demo.web.dto.base.EventDto;
import com.example.demo.web.dto.base.shorten.ShortEventDto;
import com.example.demo.web.dto.request.event.CreateEventRequest;
import com.example.demo.web.dto.request.event.DeleteEventRequest;
import com.example.demo.web.dto.request.event.GetEventRequest;
import com.example.demo.web.dto.request.event.UpdateEventRequest;
import com.example.demo.web.dto.response.event.GetEventResponse;
import com.example.demo.web.dto.response.event.GetUserEventsResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public GetEventResponse getEvent(Long eventId) {
        User user = principalService.getUser();
        Optional<UserEvent> userEvent = userEventRepository.findByEventIdAndUser(eventId, user);
        if (userEvent.isEmpty() || !userEvent.get().getRole().canView())
            return null;
        return new GetEventResponse(userEvent.get().getRole(),
                EventDto.from(userEvent.get().getEvent()));
    }

    @Override
    public GetUserEventsResponse getAllEvents() {
        User user = principalService.getUser();
        List<ShortEventDto> events = userEventRepository
                .findAllByUser(user).stream()
                .map(ue -> ShortEventDto.from(ue.getEvent(), ue.getRole()))
                .collect(Collectors.toList());
        return new GetUserEventsResponse(events);
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
