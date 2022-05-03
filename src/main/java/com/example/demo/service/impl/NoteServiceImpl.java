package com.example.demo.service.impl;

import com.example.demo.domain.entity.Note;
import com.example.demo.domain.entity.User;
import com.example.demo.domain.entity.UserEvent;
import com.example.demo.domain.entity.UserNote;
import com.example.demo.domain.enums.UserRole;
import com.example.demo.domain.repository.NoteRepository;
import com.example.demo.domain.repository.UserNoteRepository;
import com.example.demo.service.NoteService;
import com.example.demo.service.PrincipalService;
import com.example.demo.web.dto.base.EventDto;
import com.example.demo.web.dto.base.NoteDto;
import com.example.demo.web.dto.base.shorten.ShortEventDto;
import com.example.demo.web.dto.base.shorten.ShortNoteDto;
import com.example.demo.web.dto.request.note.CreateNoteRequest;
import com.example.demo.web.dto.response.event.GetEventResponse;
import com.example.demo.web.dto.response.event.GetUserEventsResponse;
import com.example.demo.web.dto.response.note.GetNoteResponse;
import com.example.demo.web.dto.response.note.GetUserNotesResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class NoteServiceImpl implements NoteService {
    NoteRepository noteRepository;
    UserNoteRepository userNoteRepository;
    PrincipalService principalService;

    @Override
    public Note create(CreateNoteRequest request) {
        Note note = new Note(request.getName(), request.getNote());
        User user = principalService.getUser();
        UserNote userNote = new UserNote(user, note, UserRole.OWNER);
        note.getUsers().add(userNote);
        return noteRepository.save(note);
    }

    @Override
    public GetNoteResponse getNote(Long noteId) {
        User user = principalService.getUser();
        Optional<UserNote> userNote = userNoteRepository.findByNoteIdAndUser(noteId, user);
        if (userNote.isEmpty() || !userNote.get().getRole().canView())
            return null;
        return new GetNoteResponse(userNote.get().getRole(),
                NoteDto.from(userNote.get().getNote()));
    }

    @Override
    public GetUserNotesResponse getAllNotes() {
        User user = principalService.getUser();
        List<ShortNoteDto> notes = userNoteRepository
                .findAllByUser(user).stream()
                .map(ue -> ShortNoteDto.from(ue.getNote(), ue.getRole()))
                .collect(Collectors.toList());
        return new GetUserNotesResponse(notes);
    }

    @Override
    public Note update(Long id, CreateNoteRequest request) {
        return null;
    }

    @Override
    public void delete(Long id) {
        noteRepository.deleteById(id);
    }
}
