package com.example.btbongda.entity;

import javax.persistence.*;

@Entity
@Table(name = "match_infors")
public class MatchInfors {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name_teama")
    private String namTeamA;

    @Column(name = "name_teamb")
    private String nameTeamB;

    @Column(name = "infors")
    private String infors;

    public MatchInfors() {
    }

    public MatchInfors(int id, String namTeamA, String nameTeamB, String infors) {
        this.id = id;
        this.namTeamA = namTeamA;
        this.nameTeamB = nameTeamB;
        this.infors = infors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamTeamA() {
        return namTeamA;
    }

    public void setNamTeamA(String namTeamA) {
        this.namTeamA = namTeamA;
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
