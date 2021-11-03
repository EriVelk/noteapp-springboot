package com.veliz.NoteApp.service.impl;

import com.veliz.NoteApp.dao.UserDAO;
import com.veliz.NoteApp.dto.UserDTO;
import com.veliz.NoteApp.entity.User;
import com.veliz.NoteApp.exception.InvalidDataException;
import com.veliz.NoteApp.mapper.UserMapper;
import com.veliz.NoteApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static com.veliz.NoteApp.utils.Constants.EMAIL_EXIST;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDAO userDAO;

    @Autowired
    UserMapper userMapper;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        if(!userDAO.existsByEmail(userDTO.getEmail())){
            userDTO.setStatus(Boolean.TRUE);
            userDTO.setRegisterDate(LocalDateTime.now());
            //Retorna
            return userMapper.userToUserDTO(userDAO.save(userMapper.userDTOToUser(userDTO)));
        }else{
            throw new InvalidDataException(EMAIL_EXIST);
        }
    }

    @Override
    public UserDTO editUser(UserDTO userDTO) {
        Optional<User> userOptional = userDAO.findById(userDTO.getId());
        User userUpdate = userOptional.get();
        userUpdate.setStatus(userDTO.getStatus());
        //Return 
        return userMapper.userToUserDTO(userDAO.save(userUpdate));
    }

    @Override
    public void deleteUser(Long id) {
        userDAO.deleteById(id);
    }


    @Override
    public List<UserDTO> listUser() {
        return userMapper.userListToUserDTOList(userDAO.findAll());
    }
}
