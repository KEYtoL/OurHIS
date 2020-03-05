package com.woniuxy.springboot.HIS.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Equipment {
	//设备id
    private Integer eid;
    //设备名称
    private String ename;
    //设备类别
    private String ecategory;
    //机身编号
    private Integer machineid;
    //出厂日期
    private Date productiondate;
    //保管人
    private String keeper;
    //规格型号 
    private String specificationid;
    //使用日期
    private Date usedate;
    //保修期限
    private String guaranteeperiod;
    //品牌
    private String ebrand;
    //折旧期限
    private String depreciationperiod;
    //设备使用状态
    private String estatus;
    //原始价值
    private Long originalprice;
    //月损耗
    private Double monthdepression;
    //存放地点
    private String storagelocation;
    //备注
    private String ps;

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename == null ? null : ename.trim();
    }

    public String getEcategory() {
        return ecategory;
    }

    public void setEcategory(String ecategory) {
        this.ecategory = ecategory == null ? null : ecategory.trim();
    }

    public Integer getMachineid() {
        return machineid;
    }

    public void setMachineid(Integer machineid) {
        this.machineid = machineid;
    }

    public Date getProductiondate() {
        return productiondate;
    }

    public void setProductiondate(Date productiondate) {
        this.productiondate = productiondate;
    }

    public String getKeeper() {
        return keeper;
    }

    public void setKeeper(String keeper) {
        this.keeper = keeper == null ? null : keeper.trim();
    }

    public String getSpecificationid() {
        return specificationid;
    }

    public void setSpecificationid(String specificationid) {
        this.specificationid = specificationid == null ? null : specificationid.trim();
    }

    public Date getUsedate() {
        return usedate;
    }

    public void setUsedate(Date usedate) {
        this.usedate = usedate;
    }

    public String getGuaranteeperiod() {
        return guaranteeperiod;
    }

    public void setGuaranteeperiod(String guaranteeperiod) {
        this.guaranteeperiod = guaranteeperiod == null ? null : guaranteeperiod.trim();
    }

    public String getEbrand() {
        return ebrand;
    }

    public void setEbrand(String ebrand) {
        this.ebrand = ebrand == null ? null : ebrand.trim();
    }

    public String getDepreciationperiod() {
        return depreciationperiod;
    }

    public void setDepreciationperiod(String depreciationperiod) {
        this.depreciationperiod = depreciationperiod == null ? null : depreciationperiod.trim();
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus == null ? null : estatus.trim();
    }

    public Long getOriginalprice() {
        return originalprice;
    }

    public void setOriginalprice(Long originalprice) {
        this.originalprice = originalprice;
    }

    public Double getMonthdepression() {
        return monthdepression;
    }

    public void setMonthdepression(Double monthdepression) {
        this.monthdepression = monthdepression;
    }

    public String getStoragelocation() {
        return storagelocation;
    }

    public void setStoragelocation(String storagelocation) {
        this.storagelocation = storagelocation == null ? null : storagelocation.trim();
    }

    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps == null ? null : ps.trim();
    }
}