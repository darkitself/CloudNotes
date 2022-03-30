package com.example.demo.service.impl;

import com.example.demo.domain.entity.User;
import com.example.demo.domain.repository.UserRepository;
import com.example.demo.service.PrincipalService;
import com.example.demo.service.SecurityService;
import com.example.demo.web.dto.LoginRequest;
import com.example.demo.web.dto.RegistrationRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class SecurityServiceImpl implements SecurityService {

    AuthenticationManager authenticationManager;
    UserRepository userRepository;
    PasswordEncoder encoder;
    PrincipalService principalService;

    @Override
    public User registration(RegistrationRequest request) {
        return userRepository.save(User.builder()
                .login(request.getLogin())
                .email(request.getEmail())
                .password(encoder.encode(request.getPassword()))
                .build()
        );
    }

    @Override
    public User login(LoginRequest request) {
        UsernamePasswordAuthenticationToken authReq
                = new UsernamePasswordAuthenticationToken(request.getLogin(), request.getPassword());
        Authentication auth = authenticationManager.authenticate(authReq);
        SecurityContext sc = SecurityContextHolder.getContext();
        sc.setAuthentication(auth);
        return principalService.getUser();
    }
}
