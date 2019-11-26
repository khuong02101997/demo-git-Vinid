package com.example.btbongda.service;
import org.springframework.beans.factory.UnsatisfiedDependencyException;
import com.example.btbongda.entity.Users;
import com.example.btbongda.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Users> getUser(){
        List<Users> users = userRepository.findAll();
        return users;
    }
    public Optional<Users> getUserId(int id){
        Optional<Users> users = userRepository.findById(id);
        return users;
    }
    public Users repairUser(Users model,int id){
        model.setId(id);
        return userRepository.save(model);
    }
    public void deleteUsers(int[] ids){
        for (int item: ids){
            userRepository.deleteById(item);
        }
    }
}
