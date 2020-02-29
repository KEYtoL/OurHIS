package com.woniuxy.springboot.HIS.entity;

public class Surgery {
    private Integer sid;

    private Integer ofpid;

    private Integer ofhid;

    private String starttime;

    private String endtime;

    private String result;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getOfpid() {
        return ofpid;
    }

    public void setOfpid(Integer ofpid) {
        this.ofpid = ofpid;
    }

    public Integer getOfhid() {
        return ofhid;
    }

    public void setOfhid(Integer ofhid) {
        this.ofhid = ofhid;
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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }
}