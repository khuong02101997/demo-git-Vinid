package com.example.btbongda.repository;


import com.example.btbongda.entity.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Tickets, Long> {

}
