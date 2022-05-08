package com.example.demo.web.controller;

import com.example.demo.domain.entity.BaseEntity;
import com.example.demo.service.ToDoListService;
import com.example.demo.web.dto.request.todolist.CreateTaskRequest;
import com.example.demo.web.dto.request.todolist.CreateToDoListRequest;
import com.example.demo.web.dto.request.todolist.UpdateToDoListRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.stream.Collectors;

@Controller
@RequestMapping("/api/todolist")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ToDoListsController {

    ToDoListService toDoListService;

    @GetMapping("/create")
    public String createToDoList(Model model) {
        return "todolist/todolist_creation";
    }

    @PostMapping("/create")
    public ModelAndView createNote(@ModelAttribute CreateToDoListRequest request, ModelMap model) {
        toDoListService.create(request);
        return new ModelAndView("redirect:/api/todolist/all", model);
    }

    @PostMapping("/delete/{noteId}")
    public ModelAndView deleteNote(@PathVariable Long noteId, ModelMap model) {
        toDoListService.delete(noteId);
        return new ModelAndView("redirect:/api/todolist/all", model);
    }

    @PostMapping("/task/create/{toDoListId}")
    public ModelAndView updateNote(@PathVariable Long toDoListId, @ModelAttribute CreateTaskRequest request, ModelMap model) {
        toDoListService.createTask(toDoListId, request);
        return new ModelAndView(String.format("redirect:/api/todolist/%d", toDoListId), model);
    }

    @PostMapping("/update/{toDoListId}")
    public ModelAndView updateNote(@PathVariable Long toDoListId, @ModelAttribute UpdateToDoListRequest request, ModelMap model) {
        toDoListService.update(toDoListId, request);
        return new ModelAndView(String.format("redirect:/api/todolist/%d", toDoListId), model);
    }

    @GetMapping("/{toDoListId}")
    public String getToDoList(@PathVariable Long toDoListId, Model model) {
        model.addAttribute("response", toDoListService.getToDoList(toDoListId));
        return "todolist/todolist";
    }

    @GetMapping("/all")
    public String getAllNotes(Model model) {
        model.addAttribute("response", toDoListService.getAllToDoLists());
        return "todolist/todolists";
    }
}
