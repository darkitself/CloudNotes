package com.example.demo.service.impl;

import com.example.demo.domain.entity.User;
import com.example.demo.domain.repository.UserRepository;
import com.example.demo.service.PrincipalService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class PrincipalServiceImpl implements PrincipalService {
    UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public User getUser() {
        var a = SecurityContextHolder
                .getContext()
                .getAuthentication().getAuthorities();
        String login = ((org.springframework.security.core.userdetails.User)SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal())
                .getUsername();
        return userRepository.findByLogin(login);
    }
}
