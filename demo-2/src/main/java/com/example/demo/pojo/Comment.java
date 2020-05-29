package com.example.demo.pojo;

import org.springframework.stereotype.Component;

@Component
public class Comment {
    private Integer id;
    private String speakName;
    private String comment;

    public Comment() {
    }

    public Comment(Integer id, String speakName, String comment) {
        this.id = id;
        this.speakName = speakName;
        this.comment = comment;
    }

    public Comment(String speakName, String comment) {
        this.speakName = speakName;
        this.comment = comment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSpeakName() {
        return speakName;
    }

    public void setSpeakName(String speakName) {
        this.speakName = speakName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
