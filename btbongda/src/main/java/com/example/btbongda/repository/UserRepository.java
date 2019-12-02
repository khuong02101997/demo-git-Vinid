package com.example.btbongda.repository;

import com.example.btbongda.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<Users, Long> {
    @Query(nativeQuery = true, value = "select name_ticket, username, email, name_ticket, number, match_name, number_seat, price, name_teama, name_teamb, infors,qr from bong.book_tickets, bong.users,bong.tickets,bong.match_infors where book_tickets.user_id = users.id and book_tickets.tickets_id = tickets.id and tickets.match_id = match_infors.id ")
    Users getInfors(@Param("id") Long id);
}