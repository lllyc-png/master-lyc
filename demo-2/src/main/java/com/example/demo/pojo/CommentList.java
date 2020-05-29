package com.example.demo.pojo;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommentList {
    private List<Comment> commentList;

    public CommentList() {
    }

    public CommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
}
