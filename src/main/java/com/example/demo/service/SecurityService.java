package com.example.demo.service;

import com.example.demo.domain.entity.User;
import com.example.demo.web.dto.request.LoginRequest;
import com.example.demo.web.dto.request.RegistrationRequest;

public interface SecurityService {
    User registration(RegistrationRequest request);
    User login(LoginRequest request);
}
