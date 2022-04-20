package com.example.demo.domain.entity;

import com.example.demo.domain.enums.UserRole;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Table(name = "users_notes")
public class UserNote extends BaseEntity  {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "note_id")
    private Note note;

    @Enumerated(EnumType.STRING)
    private UserRole role;
}
