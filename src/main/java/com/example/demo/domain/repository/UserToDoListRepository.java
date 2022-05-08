package com.example.demo.domain.repository;

import com.example.demo.domain.entity.User;
import com.example.demo.domain.entity.UserToDoList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserToDoListRepository extends JpaRepository<UserToDoList, Long> {
    Optional<UserToDoList> findByToDoListIdAndUser(Long todolist_id, User user);
    List<UserToDoList> findAllByUser(User user);
}
