package com.example.demo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    @GetMapping("/")
    public String mainPage() {
        return "main-page";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @GetMapping("/api/events/create")
    public String create_event() {
        return "event_creation";
    }

    @GetMapping("/api/notes/create")
    public String create_note() {
        return "note_creation";
    }

    @GetMapping("/api/todolists/create")
    public String create_todolist() {
        return "todolist_creation";
    }
}