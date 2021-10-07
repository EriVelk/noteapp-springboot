package com.veliz.NoteApp.dao;

import com.veliz.NoteApp.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteDAO extends JpaRepository<Note, Long> {
    @Override
    boolean existsById(Long id);
}
