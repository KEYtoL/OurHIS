package com.woniuxy.springboot.HIS.entity;

public class Historicalpatients {
    private Integer hid;

    private Integer did;

    private Integer kid;

    private Integer pid;

    private Integer room;

    private String specialtime;

    private String specialname;

    private Integer isin;

    private Integer isto;

    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public Integer getKid() {
        return kid;
    }

    public void setKid(Integer kid) {
        this.kid = kid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }

    public String getSpecialtime() {
        return specialtime;
    }

    public void setSpecialtime(String specialtime) {
        this.specialtime = specialtime == null ? null : specialtime.trim();
    }

    public String getSpecialname() {
        return specialname;
    }

    public void setSpecialname(String specialname) {
        this.specialname = specialname == null ? null : specialname.trim();
    }

    public Integer getIsin() {
        return isin;
    }

    public void setIsin(Integer isin) {
        this.isin = isin;
    }

    public Integer getIsto() {
        return isto;
    }

    public void setIsto(Integer isto) {
        this.isto = isto;
    }
}