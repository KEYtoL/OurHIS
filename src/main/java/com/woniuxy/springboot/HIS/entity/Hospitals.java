package com.woniuxy.springboot.HIS.entity;

public class Hospitals {
    private Integer hid;

    private String hname;

    private Integer horder;

    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }

    public String getHname() {
        return hname;
    }

    public void setHname(String hname) {
        this.hname = hname == null ? null : hname.trim();
    }

    public Integer getHorder() {
        return horder;
    }

    public void setHorder(Integer horder) {
        this.horder = horder;
    }
}