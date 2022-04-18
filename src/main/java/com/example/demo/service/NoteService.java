package com.example.demo.service;

import com.example.demo.domain.entity.Note;
import com.example.demo.web.dto.NoteRequest;

public interface NoteService {
    Note create(NoteRequest request);
}
