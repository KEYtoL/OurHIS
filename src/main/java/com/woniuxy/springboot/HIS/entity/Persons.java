package com.woniuxy.springboot.HIS.entity;

public class Persons {
    private Integer pid;

    private String pname;

    private String pcode;

    private String psex;

    private Integer page;

    private String pblood;

    private String paddr;

    private String pnationality;

    private String pnative;

    private String pfolk;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname == null ? null : pname.trim();
    }

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode == null ? null : pcode.trim();
    }

    public String getPsex() {
        return psex;
    }

    public void setPsex(String psex) {
        this.psex = psex == null ? null : psex.trim();
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public String getPblood() {
        return pblood;
    }

    public void setPblood(String pblood) {
        this.pblood = pblood == null ? null : pblood.trim();
    }

    public String getPaddr() {
        return paddr;
    }

    public void setPaddr(String paddr) {
        this.paddr = paddr == null ? null : paddr.trim();
    }

    public String getPnationality() {
        return pnationality;
    }

    public void setPnationality(String pnationality) {
        this.pnationality = pnationality == null ? null : pnationality.trim();
    }

    public String getPnative() {
        return pnative;
    }

    public void setPnative(String pnative) {
        this.pnative = pnative == null ? null : pnative.trim();
    }

    public String getPfolk() {
        return pfolk;
    }

    public void setPfolk(String pfolk) {
        this.pfolk = pfolk == null ? null : pfolk.trim();
    }
}