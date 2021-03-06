package com.fansz.auth.model;

import java.io.Serializable;

/**
 * Created by allan on 15/11/30.
 */
public class SessionInfoResult implements Serializable {

    private static final long serialVersionUID = 3288324419494345905L;

    private Long id;

    private String sn;

    private String accessToken;

    private String refreshToken;

    private Long lastAccessTime;

    private Long expiresAt;

    public SessionInfoResult() {

    }

    public SessionInfoResult(String accessToken, Long expiresAt) {
        this.accessToken = accessToken;
        this.expiresAt = expiresAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public Long getLastAccessTime() {
        return lastAccessTime;
    }

    public void setLastAccessTime(Long lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    public Long getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(Long expiresAt) {
        this.expiresAt = expiresAt;
    }
}
