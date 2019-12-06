package com.example.btbongda.entity;

import javax.persistence.*;
import java.util.Date;
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

    @Column(name = "time_start")
    private Date timeStart;

    @Column(name = "time_end")
    private Date timeEnd;

    @Column(name = "stadium_name")
    private String stadiumName;

    @Column(name = "ticket_status")
    private String ticketStatus;
    @Column
    private String qr;
    public Tickets(){

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

    public Date getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Date timeStart) {
        this.timeStart = timeStart;
    }

    public Date getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Date timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getStadiumName() {
        return stadiumName;
    }

    public void setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
    }

    public String getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public String getQr() {
        return qr;
    }

    public void setQr(String qr) {
        this.qr = qr;
    }

    public Tickets(Long id, Long matchId, String numberSeat, Integer price, String matchName, Date timeStart, Date timeEnd, String stadiumName, String ticketStatus, String qr) {
        this.id = id;
        this.matchId = matchId;
        this.numberSeat = numberSeat;
        this.price = price;
        this.matchName = matchName;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.stadiumName = stadiumName;
        this.ticketStatus = ticketStatus;
        this.qr = qr;
    }
}
