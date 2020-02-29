package com.woniuxy.springboot.HIS.entity;

public class Receipt {
    private Integer rid;

    private Integer cfid;

    private Integer ghid;

    private Integer ssid;

    private Integer totals;

    private Integer ofhistory;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getCfid() {
        return cfid;
    }

    public void setCfid(Integer cfid) {
        this.cfid = cfid;
    }

    public Integer getGhid() {
        return ghid;
    }

    public void setGhid(Integer ghid) {
        this.ghid = ghid;
    }

    public Integer getSsid() {
        return ssid;
    }

    public void setSsid(Integer ssid) {
        this.ssid = ssid;
    }

    public Integer getTotals() {
        return totals;
    }

    public void setTotals(Integer totals) {
        this.totals = totals;
    }

    public Integer getOfhistory() {
        return ofhistory;
    }

    public void setOfhistory(Integer ofhistory) {
        this.ofhistory = ofhistory;
    }
}