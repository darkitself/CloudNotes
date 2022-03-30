package com.example.demo.web.controller;

import com.example.demo.domain.entity.User;
import com.example.demo.service.SecurityService;
import com.example.demo.web.dto.LoginRequest;
import com.example.demo.web.dto.RegistrationRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class SecurityController {
    SecurityService securityService;

    @PostMapping("/login")
    public User login(@RequestBody LoginRequest request) {
        return securityService.login(request);
    }

    @PostMapping("/registration")
    public String registration(@RequestBody RegistrationRequest request) {
        return securityService.registration(request).getLogin();
    }
}
