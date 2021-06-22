package com.example.demo_hql.service;

import com.example.demo_hql.dto.UserDTO;
import com.example.demo_hql.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @PersistenceContext
    private EntityManager entityManager;

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
    public void createUser(String username, String password){
        userRepository.createUser(username, password);
    }

    public void deleteUser(Long id){
        userRepository.deleteUser(id);
    }
    public void updateUserPassword(Long id, String newPassword){
        userRepository.updateUserPassword(id, newPassword);
    }
    public List<UserDTO> findByUserNameContains(String s){
        return userRepository.findByUserNameContains(s);
    }

    public UserDTO findUserById(@Param("id") Long id){
        return userRepository.findUserById(id);
    }

    public List<UserDTO> findAllUnusable(){
        //responsabilidade do repository
        List<UserDTO> users = (List<UserDTO>) entityManager
                .createQuery("select u from UserDTO u")
                .getResultList();
        return users;
    }
}
