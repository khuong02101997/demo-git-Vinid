package com.example.bongda.filter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tickets")
public class Tickets extends BaseEntity{

    @OneToMany(mappedBy = "match_id")
    private List<MatchIfors> news = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "tikets_id")
    private BookTickets id;

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

    public List<MatchIfors> getNews() {
        return news;
    }

    public void setNews(List<MatchIfors> news) {
        this.news = news;
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
}
