package com.example.demo.service.impl;

import com.example.demo.domain.entity.ToDoList;
import com.example.demo.domain.entity.User;
import com.example.demo.domain.entity.UserToDolist;
import com.example.demo.domain.enums.UserRole;
import com.example.demo.domain.repository.ToDoListRepository;
import com.example.demo.service.PrincipalService;
import com.example.demo.service.ToDoListService;
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
public class ToDoListServiceImpl implements ToDoListService {
    ToDoListRepository toDoListRepository;
    PrincipalService principalService;

    @Override
    public ToDoList create(CreateToDoListRequest request) {
        ToDoList toDoList = new ToDoList(request.getName());
        User user = principalService.getUser();
        UserToDolist userToDolist = new UserToDolist(user, toDoList, UserRole.OWNER);
        toDoList.getUsers().add(userToDolist);
        return toDoListRepository.save(toDoList);
    }

    @Override
    public ToDoList get(int id) {
        return null;
    }

    @Override
    public List<ToDoList> getAll() {
        return null;
    }

    @Override
    public ToDoList update(int id, CreateToDoListRequest request) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
