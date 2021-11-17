package com.veliz.NoteApp.service;

import com.veliz.NoteApp.dto.NoteDTO;

import java.util.List;

public interface NoteService {
    NoteDTO createNote(NoteDTO noteDTO);
    List<NoteDTO> listNote(long id);
    void deleteNote(Long id);
}
