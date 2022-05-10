package com.example.demo.web.controller;

import com.example.demo.service.SecurityService;
import com.example.demo.web.dto.request.LoginRequest;
import com.example.demo.web.dto.request.RegistrationRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class SecurityController {
    SecurityService securityService;

    @GetMapping("/login")
    public String login(ModelMap model) {
        if (!model.containsAttribute("login"))
            model.addAttribute("login", "");
        return "login";
    }

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute LoginRequest request) {
        securityService.login(request);
        return new ModelAndView("redirect:/api/main");
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public ModelAndView registration(@ModelAttribute RegistrationRequest request, RedirectAttributes model) {
        securityService.registration(request);
        model.addFlashAttribute("login", request.getLogin());
        return new ModelAndView("redirect:/login", model.getFlashAttributes());
    }
}
