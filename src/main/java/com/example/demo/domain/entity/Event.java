package com.example.demo.domain.entity;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.beans.ConstructorProperties;
import java.time.Instant;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "events")
public class Event extends BaseEntity {

    public Event(String name, Instant date) {
        this.name = name;
        this.date = date;
    }

    private String name;
    private Instant date;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private Set<UserEvent> users = new HashSet<>();

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private Set<Note> notes = new HashSet<>();

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private Set<ToDoList> toDoLists = new HashSet<>();
}
