package com.example.btbongda.service;

import com.example.btbongda.entity.Users;
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
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService{
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

//    public List<Users> getUser(Long id){
//        List<Users> users = userRepository.findUserId(id);
//        return users;
//    }
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
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = new Users();
        if (users.getEmail().equals(username)) {
            String password = new BCryptPasswordEncoder().encode(users.getPassword());
            return User.withUsername(users.getUserName()).password(password).roles("USER").build();
        } else {
            throw new UsernameNotFoundException(username);
        }
    }
}
