package com.example.demo.domain.entity;

import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "notes")
public class Note extends BaseEntity {

    private String name;

    private String note;

    @OneToMany(mappedBy = "note", cascade = CascadeType.ALL)
    private Set<UserNote> users;

    @Nullable
    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;
}
