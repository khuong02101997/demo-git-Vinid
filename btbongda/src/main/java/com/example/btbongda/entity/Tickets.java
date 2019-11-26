package com.example.btbongda.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tickets")
public class Tickets {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "match_id")
    private String matchId;

    @Column(name = "name_ticket")
    private String nameTicket;

    @Column(name = "number_seat")
    private String numberSeat;

    @Column
    private int price;

    @Column(name = "match_name")
    private String matchName;

    @Column
    private String time;

    @Column(name = "stadium_name")
    private String stadiumName;

    @Column
    private String qr;

    public Tickets(int id, String matchId, String nameTicket, String numberSeat, int price, String matchName, String time, String stadiumName, String qr) {
        this.id = id;
        this.matchId = matchId;
        this.nameTicket = nameTicket;
        this.numberSeat = numberSeat;
        this.price = price;
        this.matchName = matchName;
        this.time = time;
        this.stadiumName = stadiumName;
        this.qr = qr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public String getNameTicket() {
        return nameTicket;
    }

    public void setNameTicket(String nameTicket) {
        this.nameTicket = nameTicket;
    }

    public String getNumberSeat() {
        return numberSeat;
    }

    public void setNumberSeat(String numberSeat) {
        this.numberSeat = numberSeat;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getMatchName() {
        return matchName;
    }

    public void setMatchName(String matchName) {
        this.matchName = matchName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStadiumName() {
        return stadiumName;
    }

    public void setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
    }

    public String getQr() {
        return qr;
    }

    public void setQr(String qr) {
        this.qr = qr;
    }
}
