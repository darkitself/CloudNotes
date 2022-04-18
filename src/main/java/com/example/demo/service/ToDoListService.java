package com.example.demo.service;

import com.example.demo.domain.entity.ToDoList;
import com.example.demo.web.dto.ToDoListRequest;

public interface ToDoListService {
    ToDoList create(ToDoListRequest request);
}
