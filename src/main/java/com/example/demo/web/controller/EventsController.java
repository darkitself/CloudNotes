package com.example.demo.web.controller;

import com.example.demo.service.EventsService;
import com.example.demo.web.dto.request.event.CreateEventRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/event")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class EventsController {

    EventsService eventsService;

    @GetMapping("/create")
    public String createEvent() {
        return "event_creation";
    }

    @PostMapping("/create")
    public String createEvent(@ModelAttribute CreateEventRequest request, Model model) {
        model.addAttribute("email", eventsService.create(request));
        return "main";
    }

    @GetMapping("/{eventId}")
    public String getEvent(@PathVariable Long eventId, Model model) {
        model.addAttribute("response", eventsService.getEvent(eventId));
        return "event";
    }

    @GetMapping("/all")
    public String getAllEvents(Model model) {
        model.addAttribute("response", eventsService.getAllEvents());
        return "events";
    }
}
