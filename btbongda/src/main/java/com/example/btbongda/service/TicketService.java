package com.example.btbongda.service;

import com.example.btbongda.entity.MatchInfors;
import com.example.btbongda.entity.Tickets;
import com.example.btbongda.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;
    public ResponseEntity<?> createTicket(Tickets tickets){
        try{
            Tickets newTickets = ticketRepository.save(tickets);
            return ResponseEntity.ok("Tao thong tin ve thanh cong");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Da co loi xay ra");
        }
    }
    public List<Tickets> getTickets(){
        List<Tickets> tickets = ticketRepository.findAll();
        return tickets;
    }
    public Optional<Tickets> getTicketId(Long id){
        Optional<Tickets> tickets = ticketRepository.findById(id);
        return tickets;
    }
    public Tickets updateTickets(Tickets model, Long id){
        model.setId(id);
        return ticketRepository.save(model);
    }
    public void deleteTickets(Long[] ids){
        for (Long item: ids){
            ticketRepository.deleteById(item);
        }
    }
}
