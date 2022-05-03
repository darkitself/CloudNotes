package com.example.demo.service;

import com.example.demo.domain.entity.Note;
import com.example.demo.web.dto.request.note.CreateNoteRequest;
import com.example.demo.web.dto.response.note.GetNoteResponse;
import com.example.demo.web.dto.response.note.GetUserNotesResponse;

public interface NoteService {
    Note create(CreateNoteRequest request);

    GetNoteResponse getNote(Long id);

    GetUserNotesResponse getAllNotes();

    Note update(Long id, CreateNoteRequest request);

    void delete(Long id);
}
