package com.example.demo.web.dto.base;

import com.example.demo.domain.enums.UserRole;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserDto {
    String tag;
    UserRole role;
}
