package com.example.demo_hql.repository;

import com.example.demo_hql.dto.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface UserRepository extends JpaRepository<UserDTO, Long> {


    //@Query("select user from UserDTO user")
    @Query(value = "select * from users", nativeQuery = true)
    List<UserDTO> findAllUsers();

    //@Query("select user from UserDTO user where user.username like %:name% order by user.username")
    @Query(value = "select * from users u where u.username like %:username% order by u.username", nativeQuery = true)
    List<UserDTO> findByUserNameContains(@Param("username") String s);

    @Query(value = "select * from users where users.id = :id", nativeQuery = true)
    UserDTO findUserById(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "insert into users (username, password) VALUES (:username, :password)", nativeQuery = true)
    void createUser(@Param("username") String username, @Param("password") String password);

    @Transactional
    @Modifying
    //@Query("delete from UserDTO user where user.id=:id")
    @Query(value = "delete from users where users.id = :id", nativeQuery = true)
    void deleteUser(@Param("id") Long id);

    @Transactional
    @Modifying
    //@Query("update UserDTO user set user.password=:newPassword where user.id=:id")
    @Query(value = "UPDATE users u SET u.password = :newPassword WHERE u.id = :id", nativeQuery = true)
    void updateUserPassword(@Param("id") Long id, @Param("newPassword") String newPassword);

}
