package com.example.btbongda.controller;

import com.example.btbongda.entity.MatchInfors;
import com.example.btbongda.model.ResponseData;
import com.example.btbongda.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MatchController {
    @Autowired
    private MatchService matchService;

    @PostMapping("/matchs")
    public ResponseEntity<?> crateMatchInfors(@RequestBody MatchInfors matchInfors){
//        System.out.println(matchInfors.toString());
        return matchService.createMatchInfors(matchInfors);
    }

    @GetMapping("/matchs")
    public ResponseData<MatchInfors> getMatchs(){
        return matchService.getMatchs();
    }

    @GetMapping("/matchs/{id}")
    public Optional<MatchInfors> findMatchId(@PathVariable Long id){
        return matchService.getMatchId(id);
    }

    @PutMapping("/matchs/{id}")
    public MatchInfors updateMatchs(@RequestBody MatchInfors model, @PathVariable("id") Long id){
        return matchService.updateMatchs(model,id);
    }

    @DeleteMapping("/matchs")
    public void deleteMatchs(@RequestBody Long[] ids){
        matchService.deleteMatchs(ids);
    }
}
