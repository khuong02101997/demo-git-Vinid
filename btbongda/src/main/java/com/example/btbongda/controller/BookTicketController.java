package com.example.btbongda.controller;

import com.example.btbongda.entity.BookTickets;
import com.example.btbongda.service.BookTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookTicketController {

    @Autowired
    private BookTicketService bookTicketService;

    @PostMapping("/booktickets")
    public ResponseEntity<?> creatBookTickets(@RequestBody BookTickets bookTickets){
        return bookTicketService.createBookTickets(bookTickets);
    }

    @GetMapping("/booktickets")
    public List<BookTickets> getBookTicket(){
        return bookTicketService.getBookTickets();
    }

    @GetMapping("/booktickets/{id}")
    public Optional<BookTickets> findBookTicketsId(@PathVariable Long id){
        return bookTicketService.getBookTicketId(id);
    }

    @PutMapping("/booktickets/{id}")
    public BookTickets updateBookTickets(@RequestBody BookTickets model, @PathVariable("id") Long id){
        return bookTicketService.updateBookTick(model,id);
    }

    @DeleteMapping("/booktickets")
    public void deleteBookTickets(@RequestBody Long[] ids){
        bookTicketService.deleteBookTickets(ids);
    }
}
