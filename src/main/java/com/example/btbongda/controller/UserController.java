package com.example.btbongda.controller;

import com.example.btbongda.entity.Users;
import com.example.btbongda.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;


@RestController
public class UserController {
    @Autowired
    private UserService userService;



    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody Users users){
        return userService.createUser(users);
    }

    @GetMapping("/page")
    public Page<Users> getUserPage(){
        return userService.getUserPage();
    }


    @GetMapping("/users/{id}")
    public Optional<Users> findUserId(@PathVariable Long id){
        return userService.getUserId(id);
    }
    @GetMapping("/user/{email}")
    public Optional<Users> findEmail(@PathVariable String email){
        return userService.getEmail(email);
    }


    @PutMapping("/updateusers/{id}")
    public Users repairUser(@RequestBody Users model, @PathVariable("id") Long id){
        return userService.repairUser(model, id);
    }


    @DeleteMapping("/deleteusers")
    public void deleteUsers(@RequestBody Users model, Long id){
        userService.deleteUser(model,id);
    }

}
