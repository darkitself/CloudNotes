package com.example.demo.configuration.security;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class BadCredentialsHandler {

    @ExceptionHandler(BadCredentialsException.class)
    public void handleException(BadCredentialsException ex, HttpServletResponse response) throws IOException {
        response.sendRedirect("/badcredentials");
    }
}
