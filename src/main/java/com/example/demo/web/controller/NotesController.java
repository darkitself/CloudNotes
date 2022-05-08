package com.example.demo.web.controller;

import com.example.demo.domain.entity.BaseEntity;
import com.example.demo.domain.entity.Event;
import com.example.demo.domain.repository.EventRepository;
import com.example.demo.service.NoteService;
import com.example.demo.web.dto.request.note.CreateNoteRequest;
import com.example.demo.web.dto.request.note.UpdateNoteRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.stream.Collectors;

@Controller
@RequestMapping("/api/note")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class NotesController {

    NoteService noteService;
    EventRepository eventRepository;

    @GetMapping("/create")
    public String createNote(Model model) {
        model.addAttribute("events", eventRepository.findAll()
                .stream()
                .collect(Collectors.toMap(BaseEntity::getId, Event::getName)));
        return "note/note_creation";
    }

    @PostMapping("/create")
    public String createNote(@ModelAttribute CreateNoteRequest request, Model model) {
        noteService.create(request);
        model.addAttribute("response", noteService.getAllNotes());
        return "note/notes";
    }

    @PostMapping("/delete/{noteId}")
    public ModelAndView deleteNote(@PathVariable Long noteId, ModelMap model) {
        noteService.delete(noteId);
        model.addAttribute("response", noteService.getAllNotes());
        return new ModelAndView("redirect:/api/notes/all", model);
    }

    @PostMapping("/update/{noteId}")
    public ModelAndView updateNote(@PathVariable Long noteId, @ModelAttribute UpdateNoteRequest request, ModelMap model) {
        noteService.update(noteId, request);
        model.addAttribute("response", noteService.getAllNotes());
        return new ModelAndView(String.format("redirect:/api/notes/%d", noteId), model);
    }

    @GetMapping("/{noteId}")
    public String getNote(@PathVariable Long noteId, Model model) {
        model.addAttribute("response", noteService.getNote(noteId));
        return "note/note";
    }

    @GetMapping("/all")
    public String getAllNotes(Model model) {
        model.addAttribute("response", noteService.getAllNotes());
        return "note/notes";
    }
}
