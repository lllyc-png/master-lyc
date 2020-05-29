package com.example.demo.dao;

import com.example.demo.pojo.Music;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MusicDao {
    @Select("SELECT * FROM music ORDER BY #{orderByClause}")
    public List<Music> selectMusicByOption(Object orderByClause);

    @Select(" SELECT * FROM music ")
    public List<Music> listMusic();
}
