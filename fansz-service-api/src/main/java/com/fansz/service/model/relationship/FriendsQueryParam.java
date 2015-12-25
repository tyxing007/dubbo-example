package com.fansz.service.model.relationship;


import com.fansz.common.provider.model.AccessTokenAware;
import com.fansz.common.provider.model.PageParam;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * 查询好友请求参数模型
 */
public class FriendsQueryParam extends PageParam implements AccessTokenAware {

    private static final long serialVersionUID = 1170651723025637518L;

    @JsonProperty("member_sn")
    private String currentSn;

    @JsonProperty("access_token")
    private String accessToken;

    private String relation;

    @Override
    public String getCurrentSn() {
        return currentSn;
    }

    @Override
    public void setCurrentSn(String currentSn) {
        this.currentSn = currentSn;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    @Override
    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }


}