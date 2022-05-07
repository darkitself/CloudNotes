package com.example.demo.service;

import com.example.demo.domain.entity.Note;
import com.example.demo.domain.entity.User;
import com.example.demo.domain.entity.UserNote;
import com.example.demo.domain.enums.UserRole;
import com.example.demo.domain.repository.NoteRepository;
import com.example.demo.domain.repository.UserNoteRepository;
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
    UserNoteRepository userNoteRepository;
    PrincipalService principalService;

    public Note create(CreateNoteRequest request) {
        Note note = new Note(request.getName(), request.getNote());
        User user = principalService.getUser();
        UserNote userNote = new UserNote(user, note, UserRole.OWNER);
        note.getUsers().add(userNote);
        return noteRepository.save(note);
    }

    @SneakyThrows
    public GetNoteResponse getNote(Long noteId) {
        User user = principalService.getUser();
        Optional<UserNote> userNote = userNoteRepository.findByNoteIdAndUser(noteId, user);
        if (!userNote.orElseThrow(EntityNotFoundException::new)
                .getRole().canView())
            throw new IllegalAccessException();
        return new GetNoteResponse(userNote.get().getRole(),
                NoteDto.from(userNote.get().getNote()));
    }

    public GetUserNotesResponse getAllNotes() {
        User user = principalService.getUser();
        List<ShortNoteDto> notes = userNoteRepository
                .findAllByUser(user).stream()
                .map(ue -> ShortNoteDto.from(ue.getNote(), ue.getRole()))
                .collect(Collectors.toList());
        return new GetUserNotesResponse(notes);
    }

    @SneakyThrows
    public void update(Long noteId, UpdateNoteRequest request) {
        User user = principalService.getUser();
        Optional<UserNote> userNote = userNoteRepository.findByNoteIdAndUser(noteId, user);
        if (!userNote.orElseThrow(EntityNotFoundException::new)
                .getRole().canEdit())
            throw new IllegalAccessException();
        userNote.get().getNote().updateFrom(request);
    }

    @SneakyThrows
    public void delete(Long id) {
        User user = principalService.getUser();
        UserNote userNote = userNoteRepository
                .findByNoteIdAndUser(id, user)
                .orElseThrow(EntityNotFoundException::new);
        if (userNote.getRole().canDelete())
            noteRepository.deleteById(id);
        else throw new IllegalAccessException();
    }
}
