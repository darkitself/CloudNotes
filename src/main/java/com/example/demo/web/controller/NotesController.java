package com.example.demo.web.controller;

import com.example.demo.domain.entity.BaseEntity;
import com.example.demo.domain.entity.Event;
import com.example.demo.domain.repository.EventRepository;
import com.example.demo.service.NoteService;
import com.example.demo.web.dto.request.CreateNoteRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.stream.Collectors;

@Controller
@RequestMapping("/api/notes")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class NotesController {

    NoteService noteService;
    EventRepository eventRepository;

    @GetMapping("/api/notes/create")
    public String createNote(Model model) {
        model.addAttribute("events", eventRepository.findAll()
                .stream()
                .collect(Collectors.toMap(BaseEntity::getId, Event::getName)));
        return "note_creation";
    }

    @PostMapping("/create")
    public String createNote(@ModelAttribute CreateNoteRequest request, Model model) {
        model.addAttribute("email", noteService.create(request));
        model.addAttribute("notes", noteService.getAllNotes());
        return "notes";
    }

    @GetMapping("/")
    public String getAllNotes(Model model) {
        model.addAttribute("notes", noteService.getAllNotes());
        return "notes";
    }
}
