package com.example.bongda.filter;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book_tickets")
public class BookTickets extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;

    @OneToMany(mappedBy = "id")
    private List<Tickets> newt = new ArrayList<>();

    public List<Tickets> getNewt() {
        return newt;
    }

    public void setNewt(List<Tickets> newt) {
        this.newt = newt;
    }

    @Column(name = "book_number")
    private Long bookNumber;

    @Column
    private String qr;

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Long getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(Long bookNumber) {
        this.bookNumber = bookNumber;
    }

    public String getQr() {
        return qr;
    }

    public void setQr(String qr) {
        this.qr = qr;
    }
}
