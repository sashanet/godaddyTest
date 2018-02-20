package com.godaddy.service;

import com.godaddy.dto.UserDTO;

import java.util.List;

/**
 * Created by sasha on 20.02.2018.
 */
public interface UserService {
    List<UserDTO> getAllUsers();

    UserDTO getUser(Long userId);

    void saveUser(UserDTO userDTO);

}
