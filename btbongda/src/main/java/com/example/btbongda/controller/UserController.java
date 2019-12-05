package com.example.btbongda.controller;

import com.example.btbongda.entity.Users;
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



    @PostMapping("/createusers")
    public ResponseEntity<?> createUser(@RequestBody Users users){
        return userService.createUser(users);
    }

    @GetMapping("/page")
    public Page<Users> getUserPage(){
        return userService.getUserPage();
    }

//    @GetMapping("/users")
//    public List<Users> getUser(@PathVariable Long id){
//        return userService.getUser(id);
//    }

    @GetMapping("/getusers/{id}")
    public Optional<Users> findUserId(@PathVariable Long id){
        return userService.getUserId(id);
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
