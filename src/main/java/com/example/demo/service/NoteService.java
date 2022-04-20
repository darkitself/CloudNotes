package com.example.demo.service;

import com.example.demo.domain.entity.Note;
import com.example.demo.web.dto.request.CreateNoteRequest;

import java.util.List;

public interface NoteService {
    Note create(CreateNoteRequest request);

    Note getNote(Long id);

    List<Note> getAllNotes();

    Note update(Long id, CreateNoteRequest request);

    void delete(Long id);
}
