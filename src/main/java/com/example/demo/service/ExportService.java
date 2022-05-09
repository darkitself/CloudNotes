package com.example.demo.service;

import com.example.demo.domain.entity.*;
import com.example.demo.domain.enums.UserRole;
import com.example.demo.domain.repository.*;
import com.example.demo.web.dto.response.export.ExportDto;
import com.example.demo.web.dto.response.export.ExportNote;
import com.example.demo.web.dto.response.export.ExportToDoList;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ExportService {

    PrincipalService principalService;
    UserRepository userRepository;
    ToDoListRepository toDoListRepository;
    TaskRepository taskRepository;
    UserToDoListRepository userToDoListRepository;
    NoteRepository noteRepository;

    public ExportDto export() {
        User user = principalService.getUser();
        List<ExportNote> notes = noteRepository.findAllByUser(user).stream()
                .map(ExportNote::from)
                .collect(Collectors.toList());
        List<ExportToDoList> toDoLists = userToDoListRepository.findAllByUser(user).stream()
                .filter(ul -> ul.getRole() == UserRole.OWNER)
                .map(ul -> ExportToDoList.from(ul.getToDoList()))
                .collect(Collectors.toList());
        return new ExportDto(user.getLogin(), toDoLists, notes);
    }

    public void restore(ExportDto export) {
        User user = userRepository.findByLogin(export.getLogin());
        List<Note> notes = export.getNotes().stream()
                .map(n -> Note.from(n, user))
                .collect(Collectors.toList());
        export.getToDoLists()
                .forEach(tdl -> {
                    ToDoList toDoList = toDoListRepository.save(new ToDoList(tdl.getName()));
                    userToDoListRepository.save(new UserToDoList(user, toDoList, UserRole.OWNER));
                    tdl.getTasks()
                            .forEach(t -> {
                                taskRepository.save(new Task(t.getTask(), t.getState(), toDoList));
                            });
                });
        noteRepository.saveAll(notes);
    }
}
