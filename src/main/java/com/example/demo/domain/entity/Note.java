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
@Table(name = "notes")
public class Note extends BaseEntity {

    public Note(String name, String note) {
        this.name = name;
        this.note = note;
    }

    private String name;
    private String note;

    @OneToMany(mappedBy = "note", cascade = CascadeType.ALL)
    private Set<UserNote> users = new HashSet<>();

    @Nullable
    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;
}
