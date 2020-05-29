package com.example.demo.pojo;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Anchor implements Serializable {
    private Integer anchorId;
    private String anchorName;
    private String anchorTitle;
    private String anchorContent;

    public Anchor() {
    }

    public Anchor(Integer anchorId, String anchorName, String anchorTitle, String anchorContent) {
        this.anchorId = anchorId;
        this.anchorName = anchorName;
        this.anchorTitle = anchorTitle;
        this.anchorContent = anchorContent;
    }

    public Integer getAnchorId() {
        return anchorId;
    }

    public void setAnchorId(Integer anchorId) {
        this.anchorId = anchorId;
    }

    public String getAnchorName() {
        return anchorName;
    }

    public void setAnchorName(String anchorName) {
        this.anchorName = anchorName;
    }

    public String getAnchorTitle() {
        return anchorTitle;
    }

    public void setAnchorTitle(String anchorTitle) {
        this.anchorTitle = anchorTitle;
    }

    public String getAnchorContent() {
        return anchorContent;
    }

    public void setAnchorContent(String anchorContent) {
        this.anchorContent = anchorContent;
    }

    @Override
    public String toString() {
        return "Anchor{" +
                "anchorId=" + anchorId +
                ", anchorName='" + anchorName + '\'' +
                ", anchorTitle='" + anchorTitle + '\'' +
                ", anchorContent='" + anchorContent + '\'' +
                '}';
    }
}
