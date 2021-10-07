package com.veliz.NoteApp.service.impl;

import com.veliz.NoteApp.dao.NoteDAO;
import com.veliz.NoteApp.dao.UserDAO;
import com.veliz.NoteApp.dto.NoteDTO;
import com.veliz.NoteApp.mapper.NoteMapper;
import com.veliz.NoteApp.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    NoteDAO noteDAO;

    @Autowired
    UserDAO userDAO;

    @Autowired
    NoteMapper noteMapper;


    @Override
    public NoteDTO createNote(NoteDTO noteDTO) {
        noteDTO.setRegisterDate(LocalDateTime.now());
        noteDTO.setUser(userDAO.findById(noteDTO.getUser().getId()).get());
        return noteMapper.noteToNoteDTO(noteDAO.save(noteMapper.noteDTOToNote(noteDTO)));
    }

    @Override
    public void deleteNote(Long id) {
        noteDAO.deleteById(id);
    }
}
