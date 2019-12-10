package com.example.btbongda.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "match_infors")
public class MatchInfors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "match_name")
    private String matchName;

    @Column(name = "stadium_name")
    private String stadiumName;

    @Column(name = "match_time")
    private String matchTime;


    public MatchInfors() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatchName() {
        return matchName;
    }

    public void setMatchName(String matchName) {
        this.matchName = matchName;
    }

    public String getStadiumName() {
        return stadiumName;
    }

    public void setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
    }

    public String getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(String matchTime) {
        this.matchTime = matchTime;
    }

    public MatchInfors(Long id, String matchName, String stadiumName, String matchTime) {
        this.id = id;
        this.matchName = matchName;
        this.stadiumName = stadiumName;
        this.matchTime = matchTime;
    }
}
