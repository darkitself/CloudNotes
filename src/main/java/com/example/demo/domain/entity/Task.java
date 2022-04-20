package com.example.demo.domain.entity;

import com.example.demo.domain.enums.TaskState;
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
}
