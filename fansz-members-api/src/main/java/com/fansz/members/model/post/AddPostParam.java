package com.fansz.members.model.post;

import org.codehaus.jackson.annotate.JsonProperty;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * 发post参数模型
 */
public class AddPostParam implements Serializable {

    private static final long serialVersionUID = -9003165341407262234L;

    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("member_sn")
    private String sn;

    @JsonProperty("fandom_id")
    private Long fandomId;

    @JsonProperty("post_title")
    private String postTitle;

    @Size(min = 1)
    @JsonProperty("post_content")
    private String postContent;

    @JsonProperty("post_newsfeeds")
    private String postNewsfeeds;


    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public Long getFandomId() {
        return fandomId;
    }

    public void setFandomId(Long fandomId) {
        this.fandomId = fandomId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public String getPostNewsfeeds() {
        return postNewsfeeds;
    }

    public void setPostNewsfeeds(String postNewsfeeds) {
        this.postNewsfeeds = postNewsfeeds;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
