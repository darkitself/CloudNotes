package com.example.demo.web.controller;

import com.example.demo.service.ToDoListService;
import com.example.demo.web.dto.ToDoListRequest;
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

    @PostMapping("/create")
    public String create_todolists(@ModelAttribute ToDoListRequest request, Model model) {
        model.addAttribute("email", toDoListService.create(request));
        return "greeting";
    }
}
