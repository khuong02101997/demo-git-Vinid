package com.example.btbongda.repository;

import com.example.btbongda.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {

//    @Query(nativeQuery = true, value ="SELECT * FROM users WHERE id = ?id" )
//    List<Users> findUserId(@Param("id") Long id);
    @Query(nativeQuery = true, value = "SELECT * FROM users WHERE email LIKE %:email%")
    List<Users> findOneByEmail(@Param("email") String email);
    @Query(nativeQuery = true, value = "SELECT users.username FROM users WHERE email LIKE %email%")
        Optional<Users> getEmail(@Param("email") String email);

    @Query(nativeQuery = true,value ="SELECT * FROM users WHERE username = :name" )
    Users getOneByUserName(@Param("name") String name);
    @Query(nativeQuery = true, value = "INSERT INTO `bong`.`users` (`ad`, `email`, `password`, `username`) VALUES ('?1', '?2', '?3', '?4')")
    Users createUser(@Param("ad,email,password,username") int ad, String email, String password, String username );
}