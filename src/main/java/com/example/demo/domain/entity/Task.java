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

    public Task(@NonNull String task, @NonNull TaskState state, @NonNull ToDoList toDoList) {
        this.task = task;
        this.state = state;
        this.toDoList = toDoList;
    }

    public void updateFrom(UpdateTaskRequest request) {
        task = request.getTask();
        state = request.getState();
    }

    public static Task createFrom(CreateTaskRequest request, ToDoList toDoList) {
        return new Task(request.getTask(), TaskState.TO_DO, toDoList);
    }
}
