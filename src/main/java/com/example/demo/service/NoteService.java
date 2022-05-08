package com.example.demo.service;

import com.example.demo.domain.entity.Note;
import com.example.demo.domain.entity.User;
import com.example.demo.domain.repository.NoteRepository;
import com.example.demo.web.dto.base.NoteDto;
import com.example.demo.web.dto.base.shorten.ShortNoteDto;
import com.example.demo.web.dto.request.note.CreateNoteRequest;
import com.example.demo.web.dto.request.note.UpdateNoteRequest;
import com.example.demo.web.dto.response.note.GetNoteResponse;
import com.example.demo.web.dto.response.note.GetUserNotesResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class NoteService {

    NoteRepository noteRepository;
    PrincipalService principalService;

    public Note create(CreateNoteRequest request) {
        User user = principalService.getUser();
        Note note = new Note(request.getName(), request.getNote(), user);
        return noteRepository.save(note);
    }

    @SneakyThrows
    public GetNoteResponse getNote(Long noteId) {
        User user = principalService.getUser();
        Optional<Note> note = noteRepository.findByUserIdAndId(user.getId(), noteId);
        return new GetNoteResponse(NoteDto.from(note.orElseThrow(EntityNotFoundException::new)));
    }

    public GetUserNotesResponse getAllNotes() {
        User user = principalService.getUser();
        List<ShortNoteDto> notes = noteRepository
                .findAllByUser(user).stream()
                .map(ShortNoteDto::from)
                .collect(Collectors.toList());
        return new GetUserNotesResponse(notes);
    }

    @SneakyThrows
    public void update(Long noteId, UpdateNoteRequest request) {
        User user = principalService.getUser();
        Optional<Note> note = noteRepository.findByUserIdAndId(user.getId(), noteId);
        note.orElseThrow(EntityNotFoundException::new).updateFrom(request);
    }

    @SneakyThrows
    public void delete(Long noteId) {
        User user = principalService.getUser();
        Optional<Note> note = noteRepository.findByUserIdAndId(user.getId(), noteId);
        noteRepository.delete(note.orElseThrow(EntityNotFoundException::new));
    }
}
