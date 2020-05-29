package com.example.demo.pojo;

import java.util.List;

public class AnchorAndUser {

    private List<AnchorMst> anchorList;
    private List<UserMst> userList;

    public AnchorAndUser() {
    }

    public AnchorAndUser(List<AnchorMst> anchorList, List<UserMst> userList) {
        this.anchorList = anchorList;
        this.userList = userList;
    }

    public List<AnchorMst> getAnchorList() {
        return anchorList;
    }

    public void setAnchorList(List<AnchorMst> anchorList) {
        this.anchorList = anchorList;
    }

    public List<UserMst> getUserList() {
        return userList;
    }

    public void setUserList(List<UserMst> userList) {
        this.userList = userList;
    }
}
