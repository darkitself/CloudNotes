package com.example.demo.web.dto.base;

import com.example.demo.domain.enums.TaskState;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class TaskDto {
    @NonNull
    String task;

    @NonNull
    TaskState state;
}
