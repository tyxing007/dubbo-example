package com.fansz.fandom.model.seedingspot;

import com.alibaba.fastjson.annotation.JSONField;
import com.fansz.common.provider.model.AccessTokenAware;
import com.fansz.common.provider.model.PageParam;

import java.io.Serializable;

/**
 * Created by dell on 2015/12/5.
 * 添加,删除,修改广告位传入参数
 */
public class SeedingSpotParam extends PageParam implements AccessTokenAware, Serializable {

    private static final long serialVersionUID = -899485784754811854L;

    @JSONField(name="member_sn")
    private String currentSn;

    @JSONField(name="access_token")
    private String accessToken;

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

    @Override
    public String getCurrentSn() {
        return currentSn;
    }

    @Override
    public void setCurrentSn(String currentSn) {
        this.currentSn = currentSn;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

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

}
