package com.example.btbongda.repository;

import com.example.btbongda.entity.MatchInfors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<MatchInfors, Integer> {
}
