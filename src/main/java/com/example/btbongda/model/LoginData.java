package com.example.btbongda.model;

import org.springframework.http.HttpStatus;

public class LoginData<L> {
    private HttpStatus status;
    private int code;
    private L token;

    public LoginData(){

    }

    public LoginData(HttpStatus status, int code, L token) {
        this.status = status;
        this.code = code;
        this.token = token;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public L getToken() {
        return token;
    }

    public void setToken(L token) {
        this.token = token;
    }
}
