package com.example.btbongda.repository;

import com.example.btbongda.entity.BookTickets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookTicketRepostory extends JpaRepository<BookTickets, Long> {
    @Query(nativeQuery = true,value ="SELECT * FROM book_tickets where book_status = 'chua xem'" )
    List<BookTickets> getBooksStC();
}
