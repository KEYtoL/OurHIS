package com.woniuxy.springboot.HIS.entity;

import java.util.Date;

public class Binglimingxi {
    private Integer bmid;

    private Integer bid;

    private Integer did;

    private Date bdate;

    private String badvice;

    private Integer kid;

    private byte[] expatiation;

    public Integer getBmid() {
        return bmid;
    }

    public void setBmid(Integer bmid) {
        this.bmid = bmid;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public Date getBdate() {
        return bdate;
    }

    public void setBdate(Date bdate) {
        this.bdate = bdate;
    }

    public String getBadvice() {
        return badvice;
    }

    public void setBadvice(String badvice) {
        this.badvice = badvice == null ? null : badvice.trim();
    }

    public Integer getKid() {
        return kid;
    }

    public void setKid(Integer kid) {
        this.kid = kid;
    }

    public byte[] getExpatiation() {
        return expatiation;
    }

    public void setExpatiation(byte[] expatiation) {
        this.expatiation = expatiation;
    }
}