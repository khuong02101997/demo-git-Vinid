package com.example.bongda.filter;

import javax.persistence.*;

@Entity
@Table(name = "match_infors")
public class MatchIfors extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "key_id")
    private Tickets match_id;

    @Column(name = "name_teamA")
    private String namTeamA;

    @Column(name = "name_teamB")
    private String nameTeamB;

    @Column(name = "infor")
    private String infor;

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

    public String getInfor() {
        return infor;
    }

    public void setInfor(String infor) {
        this.infor = infor;
    }
}
