package com.example.demo.service;

import com.example.demo.pojo.*;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public interface AnchorService {
    AnchorList showAnchor(String token,HttpSession session);

    String findAnchorconcern(Integer anchorId, Model model);

    String findUserconcern(Integer userId, Model model);

    AnchorAndUser showImg(String token, HttpServletResponse response,HttpSession session);

    String show(Integer pageSize, Integer pageNum, Model model);

    String register(String phone, String userName, String passWord);

    Message loginUser(String userName, String passWord, HttpSession session);

    public CommentList listComment();

    Message addComment(String speakName, String comment);

    String selectCommentByName(String speakName , Model model);

    List<MusicResult> selectOption(String option);
}
