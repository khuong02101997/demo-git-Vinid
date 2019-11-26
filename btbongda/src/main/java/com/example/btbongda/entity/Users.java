package com.example.btbongda.entity;


import sun.plugin.util.UserProfile;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name= "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @Column(name = "book_id")
    private int bookId;

    @NotNull
    @Column(name = "username", length = 100)
    private String userName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column
    private String email;

    @Column
    private boolean ad;

    public Users() {
    }

    public Users(int id, int bookId, @NotNull String userName, String password, String email, boolean ad) {
        this.id = id;
        this.bookId = bookId;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.ad = ad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAd() {
        return ad;
    }

    public void setAd(boolean ad) {
        this.ad = ad;
    }
}
