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
@Table(name = "to_do_lists")
public class ToDoList extends BaseEntity {

    private String name;

    @OneToMany(mappedBy = "toDoList", cascade = CascadeType.ALL)
    private Set<UserToDolist> users;

    @Nullable
    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;
}