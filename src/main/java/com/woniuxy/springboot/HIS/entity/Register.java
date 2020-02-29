package com.woniuxy.springboot.HIS.entity;

public class Register {
    private Integer rid;

    private Integer pid;

    private String rtime;

    private Integer rtype;

    private Integer ofhid;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getRtime() {
        return rtime;
    }

    public void setRtime(String rtime) {
        this.rtime = rtime == null ? null : rtime.trim();
    }

    public Integer getRtype() {
        return rtype;
    }

    public void setRtype(Integer rtype) {
        this.rtype = rtype;
    }

    public Integer getOfhid() {
        return ofhid;
    }

    public void setOfhid(Integer ofhid) {
        this.ofhid = ofhid;
    }
}