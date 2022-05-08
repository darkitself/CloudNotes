package com.example.demo.web.controller;

import com.example.demo.service.PrincipalService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class MainController {

    PrincipalService principalService;

    @GetMapping("/main")
    public String main(Model model) {
        model.addAttribute("email", principalService.getUser().getEmail());
        return "main";
    }
}
