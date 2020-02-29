package com.woniuxy.springboot.HIS.entity;

public class Totalpay {
    private Integer tpid;

    private Integer pid;

    private Integer did;

    private Double toitalprice;

    private Integer ispay;

    public Integer getTpid() {
        return tpid;
    }

    public void setTpid(Integer tpid) {
        this.tpid = tpid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public Double getToitalprice() {
        return toitalprice;
    }

    public void setToitalprice(Double toitalprice) {
        this.toitalprice = toitalprice;
    }

    public Integer getIspay() {
        return ispay;
    }

    public void setIspay(Integer ispay) {
        this.ispay = ispay;
    }
}