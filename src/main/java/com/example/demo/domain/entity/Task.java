package com.example.demo.domain.entity;

import com.example.demo.domain.enums.TaskState;
import com.example.demo.web.dto.request.todolist.CreateTaskRequest;
import com.example.demo.web.dto.request.todolist.UpdateTaskRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tasks")
public class Task extends BaseEntity {

    @NonNull
    String task;

    @NonNull
    @Enumerated(EnumType.STRING)
    TaskState state;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "to_do_list_id")
    ToDoList toDoList;

    public void updateFrom(UpdateTaskRequest request) {
        task = request.getTask();
        state = request.getState();
    }

    public static Task createFrom(CreateTaskRequest request, ToDoList toDoList) {
        Task task = new Task();
        task.setTask(request.getTask());
        task.setState(TaskState.TO_DO);
        task.setToDoList(toDoList);
        return task;
    }
}
