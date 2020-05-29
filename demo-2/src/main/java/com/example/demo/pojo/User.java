package com.example.demo.pojo;

import org.springframework.stereotype.Component;

@Component
public class User {
    private Integer userId;
    private String phone;
    private String userName;
    private String passWord;
    private String token;

    public User() {
    }

    public User(Integer userId, String phone, String userName, String passWord, String token) {
        this.userId = userId;
        this.phone = phone;
        this.userName = userName;
        this.passWord = passWord;
        this.token = token;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
