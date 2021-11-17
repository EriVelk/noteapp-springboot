package com.veliz.NoteApp.controller;

import com.veliz.NoteApp.dto.NoteDTO;
import com.veliz.NoteApp.dto.response.ResponseDTO;
import com.veliz.NoteApp.service.NoteService;
import com.veliz.NoteApp.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

import java.util.List;

import static com.veliz.NoteApp.utils.Constants.NOTE_DELETED;

@RestController
@RequestMapping(value = "note")
public class NoteController {
    @Autowired
    NoteService noteService;

    @PostMapping(value = "/create")
    public ResponseEntity<ResponseDTO<NoteDTO>> createNote(@RequestBody NoteDTO noteDTO){
        ResponseDTO<NoteDTO> responseDTO = new ResponseDTO<>(Constants.ResponseConstant.SUCCESS.getDescription(), noteService.createNote(noteDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}/delete")
    public ResponseEntity<ResponseDTO> deleteNote(@NotNull @PathVariable Long id){
        noteService.deleteNote(id);
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstant.SUCCESS.getDescription(), NOTE_DELETED);
        return new ResponseEntity<>(responseDTO, HttpStatus.ACCEPTED);
    }

    @GetMapping(value="/list")
    public ResponseEntity<ResponseDTO<List<NoteDTO>>> listNotes(@RequestHeader Long id){
        ResponseDTO<List<NoteDTO>> responseDTO = new ResponseDTO<>(Constants.ResponseConstant.SUCCESS.getDescription(), noteService.listNote(id));
        return new ResponseEntity<>(responseDTO, HttpStatus.ACCEPTED);
    }

}
