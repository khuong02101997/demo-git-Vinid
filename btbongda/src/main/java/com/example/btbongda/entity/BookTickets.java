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

    @Column
    private int number;
    public BookTickets(){

    }

    public BookTickets(Long id, Long user_id, Long ticketsId, String nameTicket, int number) {
        this.id = id;
        this.user_id = user_id;
        this.ticketsId = ticketsId;
        this.nameTicket = nameTicket;
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }


    public void setTicketsId(Long ticketsId) {
        this.ticketsId = ticketsId;
    }

    public String getNameTicket() {
        return nameTicket;
    }

    public void setNameTicket(String nameTicket) {
        this.nameTicket = nameTicket;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
