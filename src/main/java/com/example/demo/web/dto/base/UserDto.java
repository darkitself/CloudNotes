package com.example.demo.web.dto.base;

import com.example.demo.domain.enums.UserRole;
import lombok.Data;

@Data
public class UserDto {
    String tag;
    UserRole role;
}
