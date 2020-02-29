package com.woniuxy.springboot.HIS.entity;

public class Keshi {
    private Integer kid;

    private Integer korder;

    private String kname;

    private Integer kprice;

    private String kroom;

    public Integer getKid() {
        return kid;
    }

    public void setKid(Integer kid) {
        this.kid = kid;
    }

    public Integer getKorder() {
        return korder;
    }

    public void setKorder(Integer korder) {
        this.korder = korder;
    }

    public String getKname() {
        return kname;
    }

    public void setKname(String kname) {
        this.kname = kname == null ? null : kname.trim();
    }

    public Integer getKprice() {
        return kprice;
    }

    public void setKprice(Integer kprice) {
        this.kprice = kprice;
    }

	public String getKroom() {
		return kroom;
	}

	public void setKroom(String kroom) {
		this.kroom = kroom;
	}

    
}