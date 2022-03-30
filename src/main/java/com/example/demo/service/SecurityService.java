package com.example.demo.service;

import com.example.demo.domain.entity.User;
import com.example.demo.web.dto.LoginRequest;
import com.example.demo.web.dto.RegistrationRequest;

public interface SecurityService {
    User registration(RegistrationRequest request);
    User login(LoginRequest request);
}
