package com.example.demo.web.controller;

import com.example.demo.service.EventsService;
import com.example.demo.web.dto.EventRequest;
import com.example.demo.web.dto.LoginRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/events")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class EventsController {

    EventsService eventsService;

    @PostMapping("/create")
    public String create_event(@ModelAttribute EventRequest request, Model model) {
        model.addAttribute("email", eventsService.create(request));
        return "greeting";
    }
}
