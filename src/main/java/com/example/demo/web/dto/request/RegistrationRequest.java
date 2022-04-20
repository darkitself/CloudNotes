package com.example.demo.web.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class RegistrationRequest {
    @NotBlank
    private String login;
    @NotBlank
    private String password;
    @NotBlank
    private String email;
}
