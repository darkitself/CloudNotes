package com.example.demo.domain.entity;

import com.example.demo.web.dto.request.todolist.UpdateTaskRequest;
import com.example.demo.web.dto.request.todolist.UpdateToDoListRequest;
import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.*;

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
    @MapKey
    private Map<Long, Task> tasks = new HashMap<>();

    @OneToMany(mappedBy = "toDoList", cascade = CascadeType.ALL)
    private Set<UserToDoList> users = new HashSet<>();

    @Nullable
    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    public void updateFrom(UpdateToDoListRequest request) {
        name = request.getName();
        request.getTasks().stream().filter(UpdateTaskRequest::isNotEmpty).forEach(tr ->
        {
            if (!tasks.containsKey(tr.getId()))
                throw new EntityNotFoundException();
            tasks.get(tr.getId()).updateFrom(tr);
        });
    }
}
