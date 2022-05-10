package com.example.demo.web.controller;

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

@Controller
@RequestMapping("/api/note")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class NotesController {

    NoteService noteService;

    @GetMapping("/create")
    public String createNote(Model model) {
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
        return new ModelAndView("redirect:/api/note/all", model);
    }

    @PostMapping("/update/{noteId}")
    public ModelAndView updateNote(@PathVariable Long noteId, @ModelAttribute UpdateNoteRequest request, ModelMap model) {
        noteService.update(noteId, request);
        model.addAttribute("response", noteService.getAllNotes());
        return new ModelAndView(String.format("redirect:/api/note/%d", noteId), model);
    }

    @GetMapping("/{noteId}")
    public String getNote(@PathVariable Long noteId, Model model) {
        model.addAttribute("response", noteService.getNote(noteId));
        if (!model.containsAttribute("message"))
            model.addAttribute("message", "");
        return "note/note";
    }

    @GetMapping("/all")
    public String getAllNotes(Model model) {
        model.addAttribute("response", noteService.getAllNotes());
        return "note/notes";
    }
}
