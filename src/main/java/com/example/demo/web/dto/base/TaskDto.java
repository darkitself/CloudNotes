package com.example.demo.web.dto.base;

import com.example.demo.domain.entity.Task;
import com.example.demo.domain.enums.TaskState;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;


@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class TaskDto {
    @NonNull
    Long id;
    @NonNull
    String task;

    @NonNull
    TaskState state;

    public static TaskDto from(Task task) {
        return new TaskDto(
                task.getId(),
                task.getTask(),
                task.getState()
        );
    }
}
