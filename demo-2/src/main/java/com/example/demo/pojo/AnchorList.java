package com.example.demo.pojo;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
public class AnchorList implements Serializable {
    private List<Anchor> anchorList;

    public AnchorList() {
    }

    public AnchorList(List<Anchor> anchorList) {
        this.anchorList = anchorList;
    }

    public List<Anchor> getAnchorList() {
        return anchorList;
    }

    public void setAnchorList(List<Anchor> anchorList) {
        this.anchorList = anchorList;
    }

    @Override
    public String toString() {
        return "AnchorList{" +
                "anchorList=" + anchorList +
                '}';
    }
}
