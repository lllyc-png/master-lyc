package com.example.demo.dao;


import com.example.demo.pojo.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentDao {
    @Select("SELECT id ,speak_name AS speakName,GROUP_CONCAT(comment SEPARATOR '#') as comment " +
            " FROM comment " +
            " GROUP BY speak_name")
    public List<Comment> listComment();
    @Insert("INSERT INTO comment(speak_name,comment) VALUES(#{speakName},#{comment})")
    public void insertComment(Comment comment);
    @Select("SELECT id , " +
            " speak_name AS speakName, " +
            " GROUP_CONCAT(comment SEPARATOR '#') as comment  " +
            " FROM comment " +
            " WHERE speak_name = #{speakName}")
    public Comment selectCommentByName(String speakName);
}

