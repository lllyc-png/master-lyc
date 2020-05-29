package com.example.demo.pojo;

import java.util.List;

public class Message {
    private String token;
    private boolean message;
    private List<String> path;


    public Message() {
    }

    public Message(String token, boolean message, List<String> path) {
        this.token = token;
        this.message = message;
        this.path = path;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isMessage() {
        return message;
    }

    public void setMessage(boolean message) {
        this.message = message;
    }

    public List<String> getPath() {
        return path;
    }

    public void setPath(List<String> path) {
        this.path = path;
    }
}
