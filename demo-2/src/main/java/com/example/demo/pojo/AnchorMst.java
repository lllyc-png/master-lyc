package com.example.demo.pojo;

public class AnchorMst {
    private Integer anchorId;
    private String anchorImg;

    public AnchorMst() {
    }

    public AnchorMst(Integer anchorId, String anchorImg) {
        this.anchorId = anchorId;
        this.anchorImg = anchorImg;
    }

    public Integer getAnchorId() {
        return anchorId;
    }

    public void setAnchorId(Integer anchorId) {
        this.anchorId = anchorId;
    }

    public String getAnchorImg() {
        return anchorImg;
    }

    public void setAnchorImg(String anchorImg) {
        this.anchorImg = anchorImg;
    }
}
