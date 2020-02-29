package com.woniuxy.springboot.HIS.entity;

public class Inhistory {
    private Integer hid;

    private String starttime;

    private String endtime;

    private Integer bid;

    private Integer pid;

    private Integer ofdid;

    private Integer ofnid;

    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime == null ? null : starttime.trim();
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime == null ? null : endtime.trim();
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getOfdid() {
        return ofdid;
    }

    public void setOfdid(Integer ofdid) {
        this.ofdid = ofdid;
    }

    public Integer getOfnid() {
        return ofnid;
    }

    public void setOfnid(Integer ofnid) {
        this.ofnid = ofnid;
    }
}