package com.godaddy.controllers;

import com.godaddy.dto.UserDTO;
import com.godaddy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sasha on 19.02.2018.
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method= RequestMethod.GET)
    public List<UserDTO> getAllUsers(){
       return userService.getAllUsers();
    }

    @RequestMapping(value = "/{id}", method= RequestMethod.GET )
    public UserDTO getUser(@PathVariable Long id){
     return   userService.getUser(id);
    }

    @RequestMapping(value = "/", method= RequestMethod.POST, headers="Accept=application/json")
    public void saveUser(@RequestBody UserDTO userDTO){
        userService.saveUser(userDTO);
    }


}
