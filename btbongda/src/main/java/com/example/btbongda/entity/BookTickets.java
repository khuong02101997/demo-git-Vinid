package com.example.btbongda.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "book_tickets")
public class BookTickets {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    @Column(name = "user_id")
    private int user_id;

    @Column(name = "tickets_id")
    private String ticketsId;


    @Column(name = "name_ticket")
    private String nameTicket;

    @Column
    private int number;

    public BookTickets(int id, int user_id, String ticketsId, String nameTicket, int number) {
        this.id = id;
        this.user_id = user_id;
        this.ticketsId = ticketsId;
        this.nameTicket = nameTicket;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getTicketsId() {
        return ticketsId;
    }

    public void setTicketsId(String ticketsId) {
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
