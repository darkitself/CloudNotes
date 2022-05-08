package com.example.demo.service;

import com.example.demo.domain.entity.*;
import com.example.demo.domain.enums.TaskState;
import com.example.demo.domain.enums.UserRole;
import com.example.demo.domain.repository.TaskRepository;
import com.example.demo.domain.repository.ToDoListRepository;
import com.example.demo.domain.repository.UserToDoListRepository;
import com.example.demo.web.dto.base.ToDoListDto;
import com.example.demo.web.dto.base.shorten.ShortToDoListDto;
import com.example.demo.web.dto.request.todolist.CreateTaskRequest;
import com.example.demo.web.dto.request.todolist.CreateToDoListRequest;
import com.example.demo.web.dto.request.todolist.UpdateToDoListRequest;
import com.example.demo.web.dto.response.todolist.GetToDoListResponse;
import com.example.demo.web.dto.response.todolist.GetUserToDoListsResponse;
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
public class ToDoListService {

    TaskRepository taskRepository;
    UserToDoListRepository userToDoListRepository;
    ToDoListRepository toDoListRepository;
    PrincipalService principalService;

    public ToDoList create(CreateToDoListRequest request) {
        ToDoList toDoList = new ToDoList(request.getName());
        User user = principalService.getUser();
        UserToDoList userToDolist = new UserToDoList(user, toDoList, UserRole.OWNER);
        toDoList.getUsers().add(userToDolist);
        return toDoListRepository.save(toDoList);
    }

    @SneakyThrows
    public GetToDoListResponse getToDoList(Long toDoListId) {
        User user = principalService.getUser();
        Optional<UserToDoList> userToDoList = userToDoListRepository.findByToDoListIdAndUser(toDoListId, user);
        if (!userToDoList.orElseThrow(EntityNotFoundException::new)
                .getRole().canView())
            throw new IllegalAccessException();
        return new GetToDoListResponse(userToDoList.get().getRole(),
                ToDoListDto.from(userToDoList.get().getToDoList()),
                List.of(TaskState.values()));
    }

    public GetUserToDoListsResponse getAllToDoLists() {
        User user = principalService.getUser();
        List<ShortToDoListDto> toDoLists = userToDoListRepository
                .findAllByUser(user).stream()
                .map(ut -> ShortToDoListDto.from(ut.getToDoList(), ut.getRole()))
                .collect(Collectors.toList());
        return new GetUserToDoListsResponse(toDoLists);
    }

    @SneakyThrows
    public void update(Long toDoListId, UpdateToDoListRequest request) {
        User user = principalService.getUser();
        Optional<UserToDoList> userToDoList = userToDoListRepository.findByToDoListIdAndUser(toDoListId, user);
        if (!userToDoList.orElseThrow(EntityNotFoundException::new)
                .getRole().canEdit())
            throw new IllegalAccessException();
        userToDoList.get().getToDoList().updateFrom(request);
    }

    @SneakyThrows
    public void createTask(Long toDoListId, CreateTaskRequest request) {
        User user = principalService.getUser();
        Optional<UserToDoList> userToDoList = userToDoListRepository.findByToDoListIdAndUser(toDoListId, user);
        if (!userToDoList.orElseThrow(EntityNotFoundException::new)
                .getRole().canEdit())
            throw new IllegalAccessException();
        taskRepository.save(Task.createFrom(request, userToDoList.get().getToDoList()));
    }

    @SneakyThrows
    public void delete(Long toDoListId) {
        User user = principalService.getUser();
        UserToDoList userToDoList = userToDoListRepository
                .findByToDoListIdAndUser(toDoListId, user)
                .orElseThrow(EntityNotFoundException::new);
        if (userToDoList.getRole().canDelete())
            toDoListRepository.deleteById(toDoListId);
        else throw new IllegalAccessException();
    }
}
