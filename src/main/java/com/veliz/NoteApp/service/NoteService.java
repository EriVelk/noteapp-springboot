package com.veliz.NoteApp.service;

import com.veliz.NoteApp.dto.NoteDTO;

public interface NoteService {
    NoteDTO createNote(NoteDTO noteDTO);
    void deleteNote(Long id);
}
