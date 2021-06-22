package com.example.demo_hql.controller;

import com.example.demo_hql.dto.UserDTO;
import com.example.demo_hql.dto.UserPasswordDTO;
import com.example.demo_hql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDTO> findAllUsers(){
        return userService.findAllUsers();
    }

    @GetMapping("/{s}")
    public List<UserDTO> findByUserNameContains(@PathVariable String s){
        return null;
    }

    @GetMapping("/{id}")
    public UserDTO findUserById(@PathVariable Long id){
        return null;
    }

    @PostMapping("/create")
    public UserDTO createUser(@RequestBody UserDTO userDTO){
        return null;
    }

    @PostMapping("/save")
    public UserDTO saveUser(@RequestBody UserDTO userDTO){
        return userService.saveUser(userDTO);
    }

    @DeleteMapping("/{id}")
    public UserDTO deleteUser(@PathVariable Long id){
        return null;
    }

    @PutMapping
    public UserDTO updateUserPassword(@RequestBody UserPasswordDTO userPasswordDTO){
        return null;
    }

}
