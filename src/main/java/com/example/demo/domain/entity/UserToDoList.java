package com.example.demo.domain.entity;

import com.example.demo.domain.enums.UserRole;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Table(name = "users_to_do_lists")
public class UserToDoList extends BaseEntity  {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "to_do_list_id")
    private ToDoList toDoList;

    @Enumerated(EnumType.STRING)
    private UserRole role;
}
