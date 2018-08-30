package com.hnq.crawler.dao.domain;

import java.io.Serializable;
import java.util.Date;

public class BaiduHot implements Serializable {
    private Integer id;

    private String titleLine1;

    private Integer titleLine2;

    private String titleLine3;

    private String titleLine4;

    private String hotStockName1;

    private String hotStockCode1;

    private Double hotStockPrice1;

    private String hotStockIncrement1;

    private String hotStockName2;

    private String hotStockCode2;

    private Double hotStockPrice2;

    private String hotStockIncrement2;

    private String hotStockName3;

    private String hotStockCode3;

    private Double hotStockPrice3;

    private String hotStockIncrement3;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 最后更新时间
     */
    private Date lastUpdateDate;

    private String drivingThing;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitleLine1() {
        return titleLine1;
    }

    public void setTitleLine1(String titleLine1) {
        this.titleLine1 = titleLine1 == null ? null : titleLine1.trim();
    }

    public Integer getTitleLine2() {
        return titleLine2;
    }

    public void setTitleLine2(Integer titleLine2) {
        this.titleLine2 = titleLine2;
    }

    public String getTitleLine3() {
        return titleLine3;
    }

    public void setTitleLine3(String titleLine3) {
        this.titleLine3 = titleLine3 == null ? null : titleLine3.trim();
    }

    public String getTitleLine4() {
        return titleLine4;
    }

    public void setTitleLine4(String titleLine4) {
        this.titleLine4 = titleLine4 == null ? null : titleLine4.trim();
    }

    public String getHotStockName1() {
        return hotStockName1;
    }

    public void setHotStockName1(String hotStockName1) {
        this.hotStockName1 = hotStockName1 == null ? null : hotStockName1.trim();
    }

    public String getHotStockCode1() {
        return hotStockCode1;
    }

    public void setHotStockCode1(String hotStockCode1) {
        this.hotStockCode1 = hotStockCode1 == null ? null : hotStockCode1.trim();
    }

    public Double getHotStockPrice1() {
        return hotStockPrice1;
    }

    public void setHotStockPrice1(Double hotStockPrice1) {
        this.hotStockPrice1 = hotStockPrice1;
    }

    public String getHotStockIncrement1() {
        return hotStockIncrement1;
    }

    public void setHotStockIncrement1(String hotStockIncrement1) {
        this.hotStockIncrement1 = hotStockIncrement1 == null ? null : hotStockIncrement1.trim();
    }

    public String getHotStockName2() {
        return hotStockName2;
    }

    public void setHotStockName2(String hotStockName2) {
        this.hotStockName2 = hotStockName2 == null ? null : hotStockName2.trim();
    }

    public String getHotStockCode2() {
        return hotStockCode2;
    }

    public void setHotStockCode2(String hotStockCode2) {
        this.hotStockCode2 = hotStockCode2 == null ? null : hotStockCode2.trim();
    }

    public Double getHotStockPrice2() {
        return hotStockPrice2;
    }

    public void setHotStockPrice2(Double hotStockPrice2) {
        this.hotStockPrice2 = hotStockPrice2;
    }

    public String getHotStockIncrement2() {
        return hotStockIncrement2;
    }

    public void setHotStockIncrement2(String hotStockIncrement2) {
        this.hotStockIncrement2 = hotStockIncrement2 == null ? null : hotStockIncrement2.trim();
    }

    public String getHotStockName3() {
        return hotStockName3;
    }

    public void setHotStockName3(String hotStockName3) {
        this.hotStockName3 = hotStockName3 == null ? null : hotStockName3.trim();
    }

    public String getHotStockCode3() {
        return hotStockCode3;
    }

    public void setHotStockCode3(String hotStockCode3) {
        this.hotStockCode3 = hotStockCode3 == null ? null : hotStockCode3.trim();
    }

    public Double getHotStockPrice3() {
        return hotStockPrice3;
    }

    public void setHotStockPrice3(Double hotStockPrice3) {
        this.hotStockPrice3 = hotStockPrice3;
    }

    public String getHotStockIncrement3() {
        return hotStockIncrement3;
    }

    public void setHotStockIncrement3(String hotStockIncrement3) {
        this.hotStockIncrement3 = hotStockIncrement3 == null ? null : hotStockIncrement3.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getDrivingThing() {
        return drivingThing;
    }

    public void setDrivingThing(String drivingThing) {
        this.drivingThing = drivingThing == null ? null : drivingThing.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", titleLine1=").append(titleLine1);
        sb.append(", titleLine2=").append(titleLine2);
        sb.append(", titleLine3=").append(titleLine3);
        sb.append(", titleLine4=").append(titleLine4);
        sb.append(", hotStockName1=").append(hotStockName1);
        sb.append(", hotStockCode1=").append(hotStockCode1);
        sb.append(", hotStockPrice1=").append(hotStockPrice1);
        sb.append(", hotStockIncrement1=").append(hotStockIncrement1);
        sb.append(", hotStockName2=").append(hotStockName2);
        sb.append(", hotStockCode2=").append(hotStockCode2);
        sb.append(", hotStockPrice2=").append(hotStockPrice2);
        sb.append(", hotStockIncrement2=").append(hotStockIncrement2);
        sb.append(", hotStockName3=").append(hotStockName3);
        sb.append(", hotStockCode3=").append(hotStockCode3);
        sb.append(", hotStockPrice3=").append(hotStockPrice3);
        sb.append(", hotStockIncrement3=").append(hotStockIncrement3);
        sb.append(", createDate=").append(createDate);
        sb.append(", lastUpdateDate=").append(lastUpdateDate);
        sb.append(", drivingThing=").append(drivingThing);
        sb.append("]");
        return sb.toString();
    }
}