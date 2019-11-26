package com.example.btbongda.controller;

import com.example.btbongda.entity.MatchInfors;
import com.example.btbongda.entity.Users;
import com.example.btbongda.service.MatchService;
import com.example.btbongda.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private MatchService matchService;

    @PostMapping("/matchs")
    public ResponseEntity<?> crateMatchInfors(@RequestBody MatchInfors matchInfors){
//        System.out.println(matchInfors.toString());
        return matchService.createMatchInfors(matchInfors);
    }

    @PostMapping("/users")
    public ResponseEntity<?> createUser(@RequestBody Users users){
        return userService.createUser(users);
    }

    @GetMapping("/matchs")
    public List<MatchInfors> getMatchs(){
        return matchService.getMatchs();
    }
    @GetMapping("/users")
    public List<Users> getUser(){
        return userService.getUser();
    }

    @GetMapping("/matchs/{id}")
    public Optional<MatchInfors> findMatchId(@PathVariable int id){
        return matchService.getMatchId(id);
    }
    @GetMapping("/users/{id}")
    public Optional<Users> findUserId(@PathVariable int id){
        return userService.getUserId(id);
    }


    @PutMapping("/matchs/{id}")
    public MatchInfors updateMatchs(@RequestBody MatchInfors model, @PathVariable("id") int id){
        return matchService.updateMatchs(model,id);
    }
    @PutMapping("/users/{id}")
    public Users repairUser(@RequestBody Users model, @PathVariable("id") int id){
        return userService.repairUser(model, id);
    }

    @DeleteMapping("/matchs")
    public void deleteMatchs(@RequestBody int[] ids){
        matchService.deleteMatchs(ids);
    }
    @DeleteMapping("/users")
    public void deleteUsers(@RequestBody int[] ids){
        userService.deleteUsers(ids);
    }

}
