package com.example.demo.service;

import com.example.demo.domain.entity.ToDoList;
import com.example.demo.web.dto.request.CreateToDoListRequest;

import java.util.List;

public interface ToDoListService {
    ToDoList create(CreateToDoListRequest request);
    ToDoList get(int id);

    List<ToDoList> getAll();

    ToDoList update(int id, CreateToDoListRequest request);

    void delete(int id);
}
