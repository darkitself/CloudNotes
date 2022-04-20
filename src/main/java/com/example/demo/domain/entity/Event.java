package com.example.demo.domain.entity;

import com.example.demo.web.dto.request.event.CreateEventRequest;
import com.example.demo.web.dto.request.event.UpdateEventRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "events")
public class Event extends BaseEntity {

    private String name;
    private Instant date;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private Set<UserEvent> users = new HashSet<>();

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private Set<Note> notes = new HashSet<>();

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private Set<ToDoList> toDoLists = new HashSet<>();

    private Event(String name, Instant date) {
        this.name = name;
        this.date = date;
    }

    public static Event createFrom(CreateEventRequest createRequest) {
        return new Event(createRequest.getName(), LocalDateTime.parse(createRequest.getDate())
                .toInstant(ZoneOffset.UTC));
    }

    public Event updateFrom(UpdateEventRequest updateRequest) {
        name = updateRequest.getName();
        date = LocalDateTime.parse(updateRequest.getDate())
                .toInstant(ZoneOffset.UTC);
        return this;
    }
}
