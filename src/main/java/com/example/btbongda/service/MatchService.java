package com.example.btbongda.service;

import com.example.btbongda.entity.MatchInfors;
import com.example.btbongda.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatchService {
    @Autowired
    private MatchRepository matchRepository;
    public ResponseEntity<?> createMatchInfors(MatchInfors matchInfors){
        try{
            MatchInfors newMatch = matchRepository.save(matchInfors);
            return ResponseEntity.ok("Tao thong tin tran dau thanh cong");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Da co loi xay ra");
        }
    }
    public List<MatchInfors> getMatchs(){
        List<MatchInfors> matchInfors = matchRepository.findAll();
        return matchInfors;
    }
    public Optional<MatchInfors> getMatchId(Long id){
        Optional<MatchInfors> matchInfors = matchRepository.findById(id);
        return matchInfors;
    }
    public MatchInfors updateMatchs(MatchInfors model, Long id){
        model.setId(id);
        return matchRepository.save(model);
    }
    public void deleteMatchs(Long[] ids){
        for (Long item: ids){
            matchRepository.deleteById(item);
        }
    }
}
