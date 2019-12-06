package com.example.btbongda.entity;

import javax.persistence.*;

@Entity
@Table(name = "match_infors")
public class MatchInfors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_teama")
    private String nameTeamA;

    @Column(name = "name_teamb")
    private String nameTeamB;

    @Column(name = "infors")
    private String infors;

    public MatchInfors() {
    }

    public MatchInfors(Long id, String nameTeamA, String nameTeamB, String infors) {
        this.id = id;
        this.nameTeamA = nameTeamA;
        this.nameTeamB = nameTeamB;
        this.infors = infors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameTeamA() {
        return nameTeamA;
    }

    public void setNameTeamA(String nameTeamA) {
        this.nameTeamA = nameTeamA;
    }

    public String getNameTeamB() {
        return nameTeamB;
    }

    public void setNameTeamB(String nameTeamB) {
        this.nameTeamB = nameTeamB;
    }

    public String getInfors() {
        return infors;
    }

    public void setInfors(String infors) {
        this.infors = infors;
    }
}
