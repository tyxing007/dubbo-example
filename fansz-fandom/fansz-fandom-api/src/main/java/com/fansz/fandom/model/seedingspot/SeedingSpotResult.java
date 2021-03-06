package com.fansz.fandom.model.seedingspot;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by dell on 2015/12/5.
 */
public class SeedingSpotResult implements Serializable {

    private static final long serialVersionUID = -5881167588340820019L;
    private Long id;

    private String intro;

    @JSONField(name="priority_no")
    private Long priorityNo;

    private String status;

    @JSONField(name="click_url")
    private String clickUrl;

    @JSONField(name="seeding_type")
    private String seedingType;

    private String params;

    @JSONField(name="bg_img")
    private String bgImg;

    @JSONField(name="create_time")
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Long getPriorityNo() {
        return priorityNo;
    }

    public void setPriorityNo(Long priorityNo) {
        this.priorityNo = priorityNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getClickUrl() {
        return clickUrl;
    }

    public void setClickUrl(String clickUrl) {
        this.clickUrl = clickUrl;
    }

    public String getSeedingType() {
        return seedingType;
    }

    public void setSeedingType(String seedingType) {
        this.seedingType = seedingType;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getBgImg() {
        return bgImg;
    }

    public void setBgImg(String bgImg) {
        this.bgImg = bgImg;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
