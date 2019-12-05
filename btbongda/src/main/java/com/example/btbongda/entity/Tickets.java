package com.example.btbongda.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tickets")
public class Tickets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "match_id")
    private Long matchId;

    @Column(name = "number_seat")
    private String numberSeat;

    @Column
    private Integer price;

    @Column(name = "match_name")
    private String matchName;

    @Column
    private String time;

    @Column(name = "stadium_name")
    private String stadiumName;

    @Column
    private String qr;
    public Tickets(){

    }

    public Tickets(Long id, Long matchId, String numberSeat, Integer price, String matchName, String time, String stadiumName, String qr) {
        this.id = id;
        this.matchId = matchId;
        this.numberSeat = numberSeat;
        this.price = price;
        this.matchName = matchName;
        this.time = time;
        this.stadiumName = stadiumName;
        this.qr = qr;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    public String getNumberSeat() {
        return numberSeat;
    }

    public void setNumberSeat(String numberSeat) {
        this.numberSeat = numberSeat;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
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
