package com.example.demo.web.controller;

import com.example.demo.service.SecurityService;
import com.example.demo.web.dto.LoginRequest;
import com.example.demo.web.dto.RegistrationRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class SecurityController {
    SecurityService securityService;

    @PostMapping("/login")
    public String login(@ModelAttribute LoginRequest request, Model model) {
        model.addAttribute("email", securityService.login(request));
        return "greeting";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute RegistrationRequest request) {
        return securityService.registration(request).getLogin();
    }
}
