package com.example.demo.web.controller;

import com.example.demo.domain.entity.User;
import com.example.demo.service.SecurityService;
import com.example.demo.web.dto.LoginRequest;
import com.example.demo.web.dto.RegistrationRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class SecurityController {
    SecurityService securityService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginRequest request, Model model) {
        model.addAttribute("email", securityService.login(request));
        return "greeting";
    }

    @PostMapping("/registration")
    public String registration(@RequestBody RegistrationRequest request) {
        return securityService.registration(request).getLogin();
    }
}
