package com.example.demo.controller;

import com.example.demo.pojo.*;
import com.example.demo.service.AnchorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AnchorController {

    @Autowired
    AnchorService anchorService;

    @ResponseBody
    @PostMapping("/showAnchor")
    public AnchorList showAnchor(@RequestHeader("Authorization") String token,HttpSession session){
        return anchorService.showAnchor(token, session);
    }

    @ResponseBody
    @PostMapping("/showImg")
    public AnchorAndUser showImg(@RequestHeader("Authorization") String token, HttpServletResponse response, HttpSession session){
        return anchorService.showImg(token, response, session);
    }

    @GetMapping("/findAnchorconcern")
    public String findAnchorconcern(@RequestParam Integer anchorId , Model model){
        return anchorService.findAnchorconcern(anchorId,model);
    }

    @GetMapping("/findUserconcern")
    public String findUserconcern(@RequestParam Integer userId , Model model){
        return anchorService.findUserconcern(userId,model);
    }

    @GetMapping("/show")
    public String show(@RequestParam(defaultValue = "2") Integer pageSize, @RequestParam(defaultValue = "1") Integer pageNum, Model model){
        return anchorService.show(pageSize, pageNum, model);
    }

    @GetMapping("/register")
    public String register(@RequestParam String phone, @RequestParam String userName,@RequestParam String passWord){
        return anchorService.register(phone,userName,passWord);
    }

    @ResponseBody
    @PostMapping("/loginUser")
    public Message loginUser(@RequestParam String userName, @RequestParam String passWord , HttpSession session){
        return anchorService.loginUser(userName, passWord, session);
    }

    @ResponseBody
    @PostMapping("listComment")
    public CommentList listComment(){
        return anchorService.listComment();
    }

    @ResponseBody
    @PostMapping("/addComment")
    public Message addComment(@RequestParam String speakName, @RequestParam String comment){
        return anchorService.addComment(speakName, comment);
    }

    @PostMapping("/selectCommentByName")
    public String selectCommentByName(@RequestParam String speakName, Model model){
        return anchorService.selectCommentByName(speakName,model);
    }

    @ResponseBody
    @PostMapping("/selectOption")
    public List<MusicResult> selectOption(@RequestParam String option){
        return anchorService.selectOption(option);
    }
}
