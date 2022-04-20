package com.example.demo.domain.entity;

import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "to_do_lists")
public class ToDoList extends BaseEntity {

    public ToDoList(String name) {
        this.name = name;
    }

    private String name;

    @OneToMany(mappedBy = "toDoList", cascade = CascadeType.ALL)
    private List<Task> tasks = new LinkedList<>();

    @OneToMany(mappedBy = "toDoList", cascade = CascadeType.ALL)
    private Set<UserToDolist> users = new HashSet<>();

    @Nullable
    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;
}