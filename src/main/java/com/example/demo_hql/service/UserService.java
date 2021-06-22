package com.example.demo_hql.service;

import com.example.demo_hql.dto.UserDTO;
import com.example.demo_hql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> findAllUsers(){
        return userRepository.findAllUsers();
    }

    public UserDTO saveUser(UserDTO userDTO){
        return userRepository.save(userDTO);
    }
}
