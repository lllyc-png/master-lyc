package com.example.demo.pojo;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Music {
    private Integer id;
    private String name;
    private Integer hot;
    private Date time;
    private Object orderByClause;

    public Music() {
    }

    public Music(Integer id, String name, Integer hot, Date time) {
        this.id = id;
        this.name = name;
        this.hot = hot;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHot() {
        return hot;
    }

    public void setHot(Integer hot) {
        this.hot = hot;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Object getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(Object orderByClause) {
        this.orderByClause = orderByClause;
    }
}
