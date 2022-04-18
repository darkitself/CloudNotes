package com.example.demo.web.controller;

import com.example.demo.service.NoteService;
import com.example.demo.web.dto.NoteRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/notes")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class NotesController {

    NoteService noteService;

    @PostMapping("/create")
    public String create_note(@ModelAttribute NoteRequest request, Model model) {
        model.addAttribute("email", noteService.create(request));
        return "greeting";
    }
}
