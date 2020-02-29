package com.woniuxy.springboot.HIS.entity;

public class Payment {
    private Integer pmid;

    private Integer pid;

    private Double pmprice;

    private Integer tpid;

    public Integer getPmid() {
        return pmid;
    }

    public void setPmid(Integer pmid) {
        this.pmid = pmid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Double getPmprice() {
        return pmprice;
    }

    public void setPmprice(Double pmprice) {
        this.pmprice = pmprice;
    }

    public Integer getTpid() {
        return tpid;
    }

    public void setTpid(Integer tpid) {
        this.tpid = tpid;
    }
}