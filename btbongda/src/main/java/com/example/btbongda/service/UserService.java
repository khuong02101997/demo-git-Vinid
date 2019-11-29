package com.example.btbongda.service;

import com.example.btbongda.entity.Users;
import com.example.btbongda.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public ResponseEntity<?> createUser(Users users){
        try{
            Users newUser = userRepository.save(users);
            return ResponseEntity.ok("Tao User thanh cong");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Da co loi xay ra");
        }
    }


    public Page<Users> getUserPage(){
        Page<Users> page = userRepository.findAll(PageRequest.of(0,5, Sort.by("userName").descending()));
        return page;
    }

    public List<Users> getUser(){
        List<Users> users = userRepository.findAll();
        return users;
    }
    public Optional<Users> getUserId(Long id){
        Optional<Users> users = userRepository.findById(id);
        return users;
    }
    public Users repairUser(Users model,Long id){
        model.setId(id);
        return userRepository.save(model);
    }
//    public void deleteUsers(Integer[] ids){
//        for (Integer item: ids){
//            userRepository.deleteById(item);
//        }
//    }
    public ResponseEntity<?> deleteUser(Users model, Long id){
        model.setId(id);
        try{
            userRepository.deleteById(id);
            return ResponseEntity.ok("xoa User thanh cong");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Da co loi xay ra");
        }
    }
}
