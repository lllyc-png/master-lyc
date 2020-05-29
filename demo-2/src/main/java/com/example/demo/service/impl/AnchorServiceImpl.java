package com.example.demo.service.impl;

import com.example.demo.dao.AnchorDao;
import com.example.demo.dao.CommentDao;
import com.example.demo.dao.MusicDao;
import com.example.demo.pojo.*;
import com.example.demo.service.AnchorService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class AnchorServiceImpl implements AnchorService {

    private static final Logger logger = LoggerFactory.getLogger(AnchorServiceImpl.class);

    @Autowired
    AnchorDao anchorDao;

    @Autowired
    CommentDao commentDao;

    @Autowired
    MusicDao musicDao;

    @Override
    public AnchorList showAnchor(String token,HttpSession session) {
        String usertoken = (String)session.getAttribute("token");
        logger.info("前台传过来的token: "+token);
        logger.info("session里的token: "+usertoken);
        AnchorList anchorList = new AnchorList();
        if(token.equals(usertoken) ) {
            List<Anchor> aList = anchorDao.anchorList();
            anchorList = new AnchorList(aList);
        }else{
            return null;
        }
        return anchorList;
    }

    @Override
    public String findAnchorconcern(Integer anchorId, Model model) {

        Integer count = anchorDao.countAnchorFans(anchorId);

        if(count > 0){
            model.addAttribute("concern","已关注");
        }else{
            model.addAttribute("concern","未关注");
        }

        return "concern";
    }

    @Override
    public String findUserconcern(Integer userId, Model model) {

        Integer count = anchorDao.countUserFans(userId);

        if(count > 0){
            model.addAttribute("concern","已关注");
        }else{
            model.addAttribute("concern","未关注");
        }

        return "concern";
    }

    @Override
    public AnchorAndUser showImg(String token, HttpServletResponse response, HttpSession session) {
        String usertoken = (String)session.getAttribute("token");
        logger.info("前台传过来的token: "+token);
        logger.info("session里的token: "+usertoken);
        AnchorAndUser anchorAndUser = new AnchorAndUser();
        if(token.equals(usertoken) ){
            List<AnchorMst> anchorList = anchorDao.listAnchor();
            List<UserMst> userList = anchorDao.listUserMst();
            anchorAndUser = new AnchorAndUser(anchorList,userList);
        }else{
            return anchorAndUser;
        }

        return anchorAndUser;
    }

    @Override
    public String show(Integer pageSize, Integer pageNum, Model model) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> userList = anchorDao.listUser((pageNum-1)*pageSize,pageSize);
        PageInfo pageInfo = new PageInfo<User>(userList);
        model.addAttribute("list",userList);
        //获得当前页
        model.addAttribute("pageNum", pageInfo.getPageNum());
        //获得一页显示的条数
        model.addAttribute("pageSize", pageInfo.getPageSize());
        //获得总页数
        model.addAttribute("totalPages", pageInfo.getPages());
        model.addAttribute("isFirstPage", pageInfo.isIsFirstPage());
        model.addAttribute("isLastPage", pageInfo.isIsLastPage());

        return "show";
    }

    @Override
    public String register(String phone, String userName, String passWord) {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        anchorDao.insertUser(phone,userName,passWord,uuid);
        return "test";
    }

    @Override
    public Message loginUser(String userName, String passWord, HttpSession session) {
        User user = anchorDao.selectUserNameAndPassword(userName, passWord);
        Message message = new Message();
        if(user == null){
            message.setToken(user.getToken());
            message.setMessage(false);
        }else{
            message.setToken(user.getToken());
            message.setMessage(true);
        }
        session.setAttribute("token",user.getToken());

        return message;
    }

    @Override
    public CommentList listComment() {

        List<Comment> commentList = commentDao.listComment();
        CommentList commentResult = new CommentList(commentList);

        return commentResult;
    }

    @Override
    public Message addComment(String speakName, String comment) {
        Message message = new Message();

        Comment comment1 = new Comment(speakName,comment);
        commentDao.insertComment(comment1);
        message.setMessage(true);

        return message;
    }

    @Override
    public String selectCommentByName(String speakName, Model model) {
        Comment comment = commentDao.selectCommentByName(speakName);
        model.addAttribute("comment",comment);
        return "addcomment";
    }

    @Override
    public List<MusicResult> selectOption(String option) {
        Music music = new Music();
        List<MusicResult> musicResultList = new ArrayList<>();
        List<Music> musicList = new ArrayList<>();

        if(option.equals("1")){
            music.setOrderByClause("time DESC");
            musicList = musicDao.selectMusicByOption(music.getOrderByClause());
            for(int i = 0;i < musicList.size();i++){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String time = sdf.format(musicList.get(i).getTime());
                MusicResult musicResult = new MusicResult(musicList.get(i).getName(),musicList.get(i).getHot(),time);
                musicResultList.add(musicResult);
            }

        }else if(option.equals("2")){
            music.setOrderByClause("hot DESC");
            musicList = musicDao.selectMusicByOption(music.getOrderByClause());
            for(int i = 0;i < musicList.size();i++){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String time = sdf.format(musicList.get(i).getTime());
                MusicResult musicResult = new MusicResult(musicList.get(i).getName(),musicList.get(i).getHot(),time);
                musicResultList.add(musicResult);
            }
        }else{
            musicList = musicDao.listMusic();
            for(int i = 0;i < musicList.size();i++){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String time = sdf.format(musicList.get(i).getTime());
                MusicResult musicResult = new MusicResult(musicList.get(i).getName(),musicList.get(i).getHot(),time);
                musicResultList.add(musicResult);
            }
        }

        return musicResultList;
    }
}
