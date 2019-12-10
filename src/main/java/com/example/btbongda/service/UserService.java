package com.example.btbongda.service;

import com.example.btbongda.config.JwtToken;
import com.example.btbongda.entity.Users;
import com.example.btbongda.model.LoginData;
import com.example.btbongda.model.ResponseData;
import com.example.btbongda.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtToken token;
    public ResponseData<?> createUser(Users users){
        if (userRepository.findByEmail(users.getEmail()) != null){
            return new ResponseData(HttpStatus.OK,0,0);
        }
        if(userRepository.getOneByUserName(users.getUsername())!= null){
            return new ResponseData(HttpStatus.OK,0,0);
        }
        return new ResponseData(HttpStatus.OK,1,userRepository.createUser(users.getUsername(), passwordEncoder.encode(users.getPassword()), users.getEmail(),users.getAd()));
//        return 1;
    }

    public ResponseData<?> getUsers(){
//        if(userRepository.findAll() != null){
//            return new ResponseData(HttpStatus.NOT_FOUND,"ko co users", 0);
//        }
        return new ResponseData(HttpStatus.OK,1, userRepository.findAll());
    }

    public Page<Users> getUserPage(){
        Page<Users> page = userRepository.findAll(PageRequest.of(0,5, Sort.by("username").descending()));
        return page;
    }


    public Optional<Users> getEmail(String email){
        Optional<Users> user = userRepository.getEmail(email);
        return user;
    }
    public Users getUserId(Long id){
        Users users = userRepository.findById(id).get();
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
    public LoginData loginUser(String username, String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        username, password
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = token.generateToken((UserDetails) authentication.getPrincipal());
        return new LoginData(HttpStatus.OK,1, jwt);
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Users item = userRepository.getOneByUserName(username);
//        if (item.getUsername().equals(username)) {
//            String password = new BCryptPasswordEncoder().encode(item.getPassword());
//            return User.withUsername(item.getUsername()).password(password).build();
////                    roles(item.getAd()).build();
//        } else {
//            throw new UsernameNotFoundException(username);
//        }
//    }
}
