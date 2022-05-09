package com.example.demo.web.dto.response.export;

import com.example.demo.domain.entity.Task;
import com.example.demo.domain.enums.TaskState;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ExportTask {
    @NonNull
    String task;

    @NonNull
    TaskState state;

    public static ExportTask from(Task task) {
        return new ExportTask(
                task.getTask(),
                task.getState()
        );
    }
}
