package com.example.demo.service.impl;

import com.example.demo.domain.entity.Note;
import com.example.demo.domain.entity.User;
import com.example.demo.domain.entity.UserNote;
import com.example.demo.domain.repository.NoteRepository;
import com.example.demo.service.NoteService;
import com.example.demo.service.PrincipalService;
import com.example.demo.web.dto.NoteRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class NoteServiceImpl implements NoteService {
    NoteRepository noteRepository;
    PrincipalService principalService;

    @Override
    public Note create(NoteRequest request) {
        Note note = new Note(request.getName(), request.getNote());
        User user = principalService.getUser();
        UserNote userNote = new UserNote(user, note, "OWNER");
        note.getUsers().add(userNote);
        return noteRepository.save(note);
    }

    @Override
    public Note getNote(int id) {
        return noteRepository.getById(id);
    }

    @Override
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @Override
    public Note update(int id, NoteRequest request) {
        Note note = getNote(id);
        note.setNote(request.getNote());
        return noteRepository.save(note);
    }

    @Override
    public void delete(int id) {
        noteRepository.deleteById(id);
    }
}
