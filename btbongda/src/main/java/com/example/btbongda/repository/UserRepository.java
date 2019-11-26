package com.example.btbongda.repository;

import com.example.btbongda.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<Users, Integer> {

    }