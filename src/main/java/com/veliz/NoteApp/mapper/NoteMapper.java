package com.veliz.NoteApp.mapper;

import com.veliz.NoteApp.dto.NoteDTO;
import com.veliz.NoteApp.entity.Note;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NoteMapper {
    public Note noteDTOToNote(NoteDTO noteDTO){
        Note note = new Note();
        note.setId(noteDTO.getId());
        note.setTitle(noteDTO.getTitle());
        note.setDescription(noteDTO.getDescription());
        note.setRegisterDate(noteDTO.getRegisterDate());
        note.setUser(noteDTO.getUser());

        return note;
    }

    public NoteDTO noteToNoteDTO(Note note){
        NoteDTO noteDTO = NoteDTO.builder()
                .id(note.getId())
                .title(note.getTitle())
                .description(note.getDescription())
                .registerDate(note.getRegisterDate())
                .user(note.getUser())
                .build();

        return noteDTO;
    }

    public List<NoteDTO> noteListToNoteDTOList(List<Note> noteList){
        List<NoteDTO> noteDTOList = new ArrayList<>();
        noteList.forEach(note ->{
            noteDTOList.add(this.noteToNoteDTO(note));
        });

        return noteDTOList;
    }

}
