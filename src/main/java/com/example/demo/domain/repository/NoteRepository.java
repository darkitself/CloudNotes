package com.example.demo.domain.repository;

import com.example.demo.domain.entity.Note;
import com.example.demo.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    Optional<Note> findByUserIdAndId(Long user_id, Long id);

    List<Note> findAllByUser(User user);
}
