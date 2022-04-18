package com.example.demo.service;

import com.example.demo.domain.entity.Note;
import com.example.demo.web.dto.NoteRequest;

import java.util.List;

public interface NoteService {
    Note create(NoteRequest request);

    Note getNote(int id);

    List<Note> getAllNotes();

    Note update(int id, NoteRequest request);

    void delete(int id);
}
