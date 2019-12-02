package com.example.btbongda.controller;

import com.example.btbongda.entity.MatchInfors;
import com.example.btbongda.entity.Users;
import com.example.btbongda.service.MatchService;
import com.example.btbongda.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class UserController {
    @Autowired
    private UserService userService;



    @PostMapping("/users")
    public ResponseEntity<?> createUser(@RequestBody Users users){
        return userService.createUser(users);
    }

    @GetMapping("/page")
    public Page<Users> getUserPage(){
        return userService.getUserPage();
    }

    @GetMapping("/users")
    public List<Users> getUser(){
        return userService.getUser();
    }

    @GetMapping("/users/{id}")
    public Optional<Users> findUserId(@PathVariable Long id){
        return userService.getUserId(id);
    }



    @PutMapping("/users/{id}")
    public Users repairUser(@RequestBody Users model, @PathVariable("id") Long id){
        return userService.repairUser(model, id);
    }


    @DeleteMapping("/users")
    public void deleteUsers(@RequestBody Users model, Long id){
        userService.deleteUser(model,id);
    }

}
