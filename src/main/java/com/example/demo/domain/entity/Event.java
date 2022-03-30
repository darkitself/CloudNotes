package com.example.demo.domain.entity;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.Instant;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "events")
public class Event extends BaseEntity {

    private String name;

    private Instant date;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private Set<UserEvent> users;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<Note> notes;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<ToDoList> toDoLists;
}
