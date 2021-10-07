package com.veliz.NoteApp.dao;

import com.veliz.NoteApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Long> {
    Boolean existsByEmail(String email);
}
