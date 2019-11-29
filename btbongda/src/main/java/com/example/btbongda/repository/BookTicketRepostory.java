package com.example.btbongda.repository;

import com.example.btbongda.entity.BookTickets;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookTicketRepostory extends JpaRepository<BookTickets, Long> {
}
