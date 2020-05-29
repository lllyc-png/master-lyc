package com.example.demo.pojo;

import org.springframework.stereotype.Component;

@Component
public class MusicResult {
    private String name;
    private Integer hot;
    private String time;

    public MusicResult() {
    }

    public MusicResult(String name, Integer hot, String time) {
        this.name = name;
        this.hot = hot;
        this.time = time;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
