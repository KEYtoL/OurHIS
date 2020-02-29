package com.woniuxy.springboot.HIS.entity;

public class Ondutyinfo {
    private Integer odid;

    private Integer pid;

    private String odtype;

    private String odstart;

    private String odend;

    private Integer odroom;

    private Integer oddep;

    private Boolean ischangeshifts;

    private Integer changeinfo;

    public Integer getOdid() {
        return odid;
    }

    public void setOdid(Integer odid) {
        this.odid = odid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getOdtype() {
        return odtype;
    }

    public void setOdtype(String odtype) {
        this.odtype = odtype == null ? null : odtype.trim();
    }

    public String getOdstart() {
        return odstart;
    }

    public void setOdstart(String odstart) {
        this.odstart = odstart == null ? null : odstart.trim();
    }

    public String getOdend() {
        return odend;
    }

    public void setOdend(String odend) {
        this.odend = odend == null ? null : odend.trim();
    }

    public Integer getOdroom() {
        return odroom;
    }

    public void setOdroom(Integer odroom) {
        this.odroom = odroom;
    }

    public Integer getOddep() {
        return oddep;
    }

    public void setOddep(Integer oddep) {
        this.oddep = oddep;
    }

    public Boolean getIschangeshifts() {
        return ischangeshifts;
    }

    public void setIschangeshifts(Boolean ischangeshifts) {
        this.ischangeshifts = ischangeshifts;
    }

    public Integer getChangeinfo() {
        return changeinfo;
    }

    public void setChangeinfo(Integer changeinfo) {
        this.changeinfo = changeinfo;
    }
}