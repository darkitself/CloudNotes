package com.example.demo.domain.entity;

import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "to_do_lists")
public class ToDoList extends BaseEntity {

    public ToDoList(String name, String toDoList) {
        this.name = name;
        this.toDoList = toDoList;
    }

    private String name;
    private String toDoList;

    @OneToMany(mappedBy = "toDoList", cascade = CascadeType.ALL)
    private Set<UserToDolist> users = new HashSet<>();

    @Nullable
    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;
}