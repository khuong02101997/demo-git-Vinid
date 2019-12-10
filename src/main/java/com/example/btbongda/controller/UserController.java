package com.example.btbongda.controller;

import com.example.btbongda.entity.Users;
import com.example.btbongda.model.ResponseData;
import com.example.btbongda.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.HashMap;
import java.util.Optional;


@RestController
//@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@Valid @RequestBody Users users){
        return ResponseEntity.ok(userService.createUser(users));
    }

    @GetMapping("/page")
    public Page<Users> getUserPage(){
        return userService.getUserPage();
    }

    @GetMapping("/getUsers")
    public ResponseData<?> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/users/{id}")
    public Users findUserId(@PathVariable Long id){
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

//    @ApiOperation(value = "Đăng nhập - Get token login")
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@Valid @RequestBody HashMap<String, String> request){
        return ResponseEntity.ok(userService.loginUser(request.get("username"), request.get("password")));
    }

}
