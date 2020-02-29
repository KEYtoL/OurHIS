package com.woniuxy.springboot.HIS.entity;

public class Beds {
    private Integer bid;

    private Integer isnull;

    private Integer btype;

    private Integer bprice;

    private String baddr;

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getIsnull() {
        return isnull;
    }

    public void setIsnull(Integer isnull) {
        this.isnull = isnull;
    }

    public Integer getBtype() {
        return btype;
    }

    public void setBtype(Integer btype) {
        this.btype = btype;
    }

    public Integer getBprice() {
        return bprice;
    }

    public void setBprice(Integer bprice) {
        this.bprice = bprice;
    }

    public String getBaddr() {
        return baddr;
    }

    public void setBaddr(String baddr) {
        this.baddr = baddr == null ? null : baddr.trim();
    }
}