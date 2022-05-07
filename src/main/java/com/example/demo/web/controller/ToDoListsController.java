package com.example.demo.web.controller;

import com.example.demo.service.ToDoListService;
import com.example.demo.web.dto.request.CreateToDoListRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/todolists")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ToDoListsController {

    ToDoListService toDoListService;

    @GetMapping("/create")
    public String createToDoList() {
        return "todolist_creation";
    }

    @PostMapping("/create")
    public String createToDoList(@ModelAttribute CreateToDoListRequest request, Model model) {
        model.addAttribute("email", toDoListService.create(request));
        return "main";
    }

    @GetMapping("/all")
    public String getAllToDoLists() {
        return "todolist_creation";
    }
}
