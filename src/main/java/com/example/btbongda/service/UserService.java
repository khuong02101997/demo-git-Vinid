package com.example.btbongda.service;

import com.example.btbongda.entity.Users;
import com.example.btbongda.model.ResponseData;
import com.example.btbongda.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    public ResponseData<?> createUser(Users users){
//        userRepository.save(users);
//        if (userRepository.findByEmail(users.getEmail()) != null){
//            return new ResponseData(HttpStatus.OK,"email da dang ky",0);
//        }
        return new ResponseData(HttpStatus.OK,"COn chim nho nho",userRepository.createUser(users.getUsername(), users.getPassword(), users.getEmail(),users.getAd()));
//        return 1;
    }


    public Page<Users> getUserPage(){
        Page<Users> page = userRepository.findAll(PageRequest.of(0,5, Sort.by("userName").descending()));
        return page;
    }


    public Optional<Users> getEmail(String email){
        Optional<Users> user = userRepository.getEmail(email);
        return user;
    }
    public Optional<Users> getUserId(Long id){
        Optional<Users> users = userRepository.findById(id);
        return users;
    }

    public Users repairUser(Users model,Long id){
        model.setId(id);
        return userRepository.save(model);
    }
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
