package com.example.demo.web.dto.base;

import com.example.demo.domain.enums.TaskState;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class TaskDto {
    @NonNull
    String task;

    @NonNull
    TaskState state;
}
