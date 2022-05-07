package com.example.demo.domain.repository;

import com.example.demo.domain.entity.User;
import com.example.demo.domain.entity.UserNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserNoteRepository extends JpaRepository<UserNote, Long> {
    Optional<UserNote> findByNoteIdAndUser(Long note_id, User user);
    List<UserNote> findAllByUser(User user);
}
