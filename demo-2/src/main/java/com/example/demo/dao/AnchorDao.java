package com.example.demo.dao;

import com.example.demo.pojo.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface AnchorDao {
    @Select("SELECT anchor_id AS anchorId," +
            " anchor_name AS anchorName," +
            " anchor_title AS anchorTitle," +
            " anchor_content AS anchorContent" +
            " FROM anchor")
    public List<Anchor> anchorList();

    @Select("SELECT COUNT(*) FROM anchor_user_mst WHERE anchor_id = #{anchorId}")
    public Integer countAnchorFans(Integer anchorId);

    @Select("SELECT COUNT(*) FROM user_fans_mst WHERE user_id = #{userId}")
    public Integer countUserFans(Integer userId);

    @Select("SELECT anchor_id as anchorId,anchor_img as anchorImg FROM anchor_mst")
    public List<AnchorMst> listAnchor();

    @Select("SELECT user_id as userId , user_img as userImg FROM user_mst")
    public List<UserMst> listUserMst();

    @Select("SELECT user_id as userId,phone,user_name as userName,password as passWord FROM t_user")
    public List<User> listUser(Integer pageNum, Integer pageSize);

    @Insert("INSERT INTO t_user(phone,user_name,password,token) VALUES(#{phone},#{userName},#{passWord},#{token})")
    public void insertUser(String phone, String userName, String passWord, String token);

    @Select("SELECT * FROM t_user WHERE user_name = #{userName} AND password = #{passWord}")
    public User selectUserNameAndPassword(String userName, String passWord);
}
