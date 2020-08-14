package com.example.demo.mapper;

import com.example.demo.entity.XP;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    public String getCode(@Param("id") String id);

    public Integer getId(@Param("code") String code);

    public List<XP> listXP();
}
