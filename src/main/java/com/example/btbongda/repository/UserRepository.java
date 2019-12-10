package com.example.btbongda.repository;

import com.example.btbongda.entity.Users;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    @Query(nativeQuery = true, value ="SELECT * FROM users" )
    List<Users> findUser(Users users);

    @Query(nativeQuery = true, value = "SELECT * FROM users WHERE email LIKE %:email%")
    List<Users> findOneByEmail(@Param("email") String email);
    @Query(nativeQuery = true, value = "SELECT * FROM users WHERE email LIKE %email%")
        Optional<Users> getEmail(@Param("email") String email);

    @Query(nativeQuery = true,value ="SELECT * FROM users WHERE username = :name" )
    Users getOneByUserName(@Param("name") String name);

//    Users findByUsername(String username);
    @Query(nativeQuery = true, value = "SELECT * FROM users WHERE email = ?1")
    Users findByEmail(String email);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO users (username,password,email,ad) VALUES (?1,?2,?3,?4)",nativeQuery = true )
    Integer createUser( String username, String password, String email,String ad );
    @Query(nativeQuery = true, value = "SELECT * FROM users WHERE username =:username")
    Users findByUsername(String username);
}