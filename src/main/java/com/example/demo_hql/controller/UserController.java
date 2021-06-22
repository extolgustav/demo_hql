package com.example.demo_hql.controller;

import com.example.demo_hql.dto.UserDTO;
import com.example.demo_hql.dto.UserNewPasswordDTO;
import com.example.demo_hql.service.UserService;
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

    @GetMapping("/findname/{s}")
    public List<UserDTO> findByUserNameContains(@PathVariable String s){
        return userService.findByUserNameContains(s);
    }

    @GetMapping("/find/test")
    public List<UserDTO> findAllUnusable(){
        return userService.findAllUnusable();
    }

    @GetMapping("/find/{id}")
    public UserDTO findUserById(@PathVariable Long id){
        return userService.findUserById(id);
    }

    @PostMapping("/create")
    public void createUser(@RequestBody UserDTO userDTO){
        userService.createUser(userDTO.getUsername(), userDTO.getPassword());
    }

    @PostMapping("/save")
    public UserDTO saveUser(@RequestBody UserDTO userDTO){
        return userService.saveUser(userDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

    @PutMapping
    public void updateUserPassword(@RequestBody UserNewPasswordDTO userPasswordDTO){
        userService.updateUserPassword(userPasswordDTO.getId(), userPasswordDTO.getNewPassword());
    }
}
