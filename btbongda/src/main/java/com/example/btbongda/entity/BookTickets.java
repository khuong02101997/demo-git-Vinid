package com.example.btbongda.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "book_tickets")
public class BookTickets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "tickets_id")
    private Long ticketsId;

    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "name_ticket")
    private String nameTicket;

    @Column (name = "book_status")
    private String bookStatus;

    public BookTickets(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTicketsId() {
        return ticketsId;
    }

    public void setTicketsId(Long ticketsId) {
        this.ticketsId = ticketsId;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getNameTicket() {
        return nameTicket;
    }

    public void setNameTicket(String nameTicket) {
        this.nameTicket = nameTicket;
    }

    public String getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(String bookStatus) {
        this.bookStatus = bookStatus;
    }

    public BookTickets(Long id, Long ticketsId, Long user_id, String nameTicket, String bookStatus) {
        this.id = id;
        this.ticketsId = ticketsId;
        this.user_id = user_id;
        this.nameTicket = nameTicket;
        this.bookStatus = bookStatus;
    }
}
