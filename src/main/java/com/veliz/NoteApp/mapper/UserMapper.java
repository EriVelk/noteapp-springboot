package com.veliz.NoteApp.mapper;

import com.veliz.NoteApp.dto.UserDTO;
import com.veliz.NoteApp.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {
    public User userDTOToUser(UserDTO userDTO){
        User user = new User();
        user.setId(userDTO.getId());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setAge(userDTO.getAge());
        user.setRegisterDate(userDTO.getRegisterDate());
        user.setStatus(userDTO.getStatus());
        user.setNoteList(userDTO.getNoteList());

        return user;
    }

    public UserDTO userToUserDTO(User user){
        UserDTO userDTO = UserDTO.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .age(user.getAge())
                .registerDate(user.getRegisterDate())
                .status(user.getStatus())
                .noteList(user.getNoteList())
                .build();

        return userDTO;
    }

    public List<UserDTO> userListToUserDTOList(List<User> userList){
        List<UserDTO> userDTOList = new ArrayList<>();
        userList.forEach(user ->{
            userDTOList.add(this.userToUserDTO(user));
        });

        return userDTOList;
    }
}
