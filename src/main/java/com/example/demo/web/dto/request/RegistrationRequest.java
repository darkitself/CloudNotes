package com.example.demo.web.dto.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;

@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class RegistrationRequest {
    @NotBlank String login;
    @NotBlank String password;
    @NotBlank String email;
}
