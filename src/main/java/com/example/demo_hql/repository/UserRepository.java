package com.example.demo_hql.repository;

import com.example.demo_hql.dto.UserDTO;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserDTO, Long> {


    @Query("select user from UserDTO user")
    List<UserDTO> findAllUsers();

    //List<UserDTO> findByUserNameContains(String s);

    // UserDTO findUserById(Long id);

    // UserDTO createUser(UserDTO userDTO);

    // UserDTO deleteUser(Long id);

    // UserDTO updateUserPassword(Long id, String newPassword);

}
