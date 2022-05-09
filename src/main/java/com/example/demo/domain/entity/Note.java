package com.example.demo.domain.entity;

import com.example.demo.web.dto.request.note.UpdateNoteRequest;
import com.example.demo.web.dto.response.export.ExportNote;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "notes")
public class Note extends BaseEntity {

    public Note(String name, String note, User user) {
        this.name = name;
        this.note = note;
        this.user = user;
    }

    private String name;
    private String note;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public static Note from(ExportNote n, User user) {
        return new Note(n.getName(), n.getNote(), user);
    }

    public void updateFrom(UpdateNoteRequest updateRequest) {
        name = updateRequest.getName();
        note = updateRequest.getNote();
    }
}