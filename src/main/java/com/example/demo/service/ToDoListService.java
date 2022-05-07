package com.example.demo.service;

import com.example.demo.domain.entity.ToDoList;
import com.example.demo.domain.entity.User;
import com.example.demo.domain.entity.UserToDolist;
import com.example.demo.domain.enums.UserRole;
import com.example.demo.domain.repository.ToDoListRepository;
import com.example.demo.web.dto.request.CreateToDoListRequest;
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
public class ToDoListService {
    ToDoListRepository toDoListRepository;
    PrincipalService principalService;

    public ToDoList create(CreateToDoListRequest request) {
        ToDoList toDoList = new ToDoList(request.getName());
        User user = principalService.getUser();
        UserToDolist userToDolist = new UserToDolist(user, toDoList, UserRole.OWNER);
        toDoList.getUsers().add(userToDolist);
        return toDoListRepository.save(toDoList);
    }

    public ToDoList get(int id) {
        return null;
    }

    public List<ToDoList> getAll() {
        return null;
    }

    public ToDoList update(int id, CreateToDoListRequest request) {
        return null;
    }

    public void delete(int id) {

    }
}
