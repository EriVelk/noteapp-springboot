package com.veliz.NoteApp.service;

import com.veliz.NoteApp.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO createUser (UserDTO userDTO);
    UserDTO editUser (UserDTO userDTO);
    void deleteUser (Long id);
    List<UserDTO> listUser();
}
