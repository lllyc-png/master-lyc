package com.example.demo.pojo;

public class UserMst {

    private Integer userId;
    private String userImg;

    public UserMst() {
    }

    public UserMst(Integer userId, String userImg) {
        this.userId = userId;
        this.userImg = userImg;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }
}
