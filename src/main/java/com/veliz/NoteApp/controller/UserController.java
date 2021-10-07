package com.veliz.NoteApp.controller;

import com.veliz.NoteApp.dto.UserDTO;
import com.veliz.NoteApp.dto.response.ResponseDTO;
import com.veliz.NoteApp.entity.User;
import com.veliz.NoteApp.service.UserService;
import com.veliz.NoteApp.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

import java.util.List;

import static com.veliz.NoteApp.utils.Constants.USER_DELETED;

@RestController
@RequestMapping(value = "user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(value = "/create")
    public ResponseEntity<ResponseDTO<UserDTO>> createUser(@RequestBody UserDTO userDTO){
        ResponseDTO<UserDTO> responseDTO = new ResponseDTO<>(Constants.ResponseConstant.SUCCESS.getDescription(), userService.createUser(userDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/status")
    public ResponseEntity<ResponseDTO<User>> statusUser(@RequestBody UserDTO userDTO){
        ResponseDTO<UserDTO> responseDTO = new ResponseDTO<>(Constants.ResponseConstant.SUCCESS.getDescription(), userService.editUser(userDTO));
        return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/{id}/delete")
    public ResponseEntity<ResponseDTO> deleteUser(@NotNull @PathVariable Long id){
        userService.deleteUser(id);
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstant.SUCCESS.getDescription() , USER_DELETED);
        return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/list")
    public ResponseEntity<ResponseDTO<List<UserDTO>>> listUser(){
        ResponseDTO<List<UserDTO>> responseDTO = new ResponseDTO<>(Constants.ResponseConstant.SUCCESS.getDescription(), userService.listUser());
        return new ResponseEntity<>(responseDTO, HttpStatus.ACCEPTED);
    }

}
