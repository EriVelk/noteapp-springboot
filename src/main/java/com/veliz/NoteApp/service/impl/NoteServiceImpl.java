package com.veliz.NoteApp.service.impl;

import com.veliz.NoteApp.dao.NoteDAO;
import com.veliz.NoteApp.dao.UserDAO;
import com.veliz.NoteApp.dto.NoteDTO;
import com.veliz.NoteApp.entity.Note;
import com.veliz.NoteApp.entity.User;
import com.veliz.NoteApp.mapper.NoteMapper;
import com.veliz.NoteApp.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
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
        Note note = new Note();
        User user = new User();
        user.setId(id);
        note.setUser(user);
        Example<Note> example = Example.of(note);
        return noteMapper.noteListToNoteDTOList(noteDAO.findAll(example));
    }

    @Override
    public void deleteNote(Long id) {
        noteDAO.deleteById(id);
    }
}
