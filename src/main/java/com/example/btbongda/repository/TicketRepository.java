package com.example.btbongda.repository;


import com.example.btbongda.entity.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TicketRepository extends JpaRepository<Tickets, Long> {
    @Query(nativeQuery = true,value ="SELECT * FROM tickets WHERE ticket_status ='chua mua'" )
    List<Tickets> getTicketsStT();

}
