package com.veliz.NoteApp.service.impl;

import com.veliz.NoteApp.dao.NoteDAO;
import com.veliz.NoteApp.dao.UserDAO;
import com.veliz.NoteApp.dto.NoteDTO;
import com.veliz.NoteApp.mapper.NoteMapper;
import com.veliz.NoteApp.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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
    public List<NoteDTO> listNote(long id) {
        return noteMapper.noteListToNoteDTOList((noteDAO.listNote(id)));
    }

    @Override
    public void deleteNote(Long id) {
        noteDAO.deleteById(id);
    }
}
