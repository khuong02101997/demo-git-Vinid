package com.example.btbongda.controller;

import com.example.btbongda.entity.Tickets;
import com.example.btbongda.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @PostMapping("/tickets")
    public ResponseEntity<?> createTickets(@RequestBody Tickets tickets){
        return ticketService.createTicket(tickets);
    }

    @GetMapping("/tickets")
    public List<Tickets> getTicket(){
        return ticketService.getTickets();
    }


    @GetMapping("/tickets/{id}")
    public Optional<Tickets> findTicketsId(@PathVariable Long id){
        return ticketService.getTicketId(id);
    }



    @PutMapping("/tickets/{id}")
    public Tickets updateTickets(@RequestBody Tickets model, @PathVariable("id") Long id){
        return ticketService.updateTickets(model,id);
    }


    @DeleteMapping("/tickets")
    public void deleteTickets(@RequestBody Long[] ids){
        ticketService.deleteTickets(ids);
    }
}
