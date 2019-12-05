package com.example.btbongda.service;

import com.example.btbongda.entity.BookTickets;
import com.example.btbongda.repository.BookTicketRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookTicketService {
    @Autowired
    private BookTicketRepostory bookTicketRepostory;
    public ResponseEntity<?> createBookTickets(BookTickets bookTickets){
        try{
            BookTickets newBookTicket = bookTicketRepostory.save(bookTickets);
            return ResponseEntity.ok("Tao thong tin book ve thanh cong");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Da co loi xay ra");
        }
    }
    public List<BookTickets> getBookTickets(){
        List<BookTickets> bookTickets = bookTicketRepostory.findAll();
        return bookTickets;
    }
    public Optional<BookTickets> getBookTicketId(long id){
        Optional<BookTickets> bookTickets = bookTicketRepostory.findById(id);
        return bookTickets;
    }
    public BookTickets updateBookTick(BookTickets model, Long id){
        model.setId(id);
        return bookTicketRepostory.save(model);
    }
    public void deleteBookTickets(Long[] ids){
        for (Long item: ids){
            bookTicketRepostory.deleteById(item);
        }
    }

}
