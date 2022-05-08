package com.example.demo.web.dto.request.todolist;

import com.example.demo.domain.enums.TaskState;
import lombok.Data;
import org.springframework.util.StringUtils;

@Data
public class UpdateTaskRequest {
    Long id;
    String task;
    TaskState state;

    public boolean isNotEmpty() {
        return id != null && StringUtils.hasText(task) && state != null;
    }
}
