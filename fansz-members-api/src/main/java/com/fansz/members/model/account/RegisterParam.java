package com.fansz.members.model.account;

import java.io.Serializable;

/**
 * 用户注册参数
 */


public class RegisterParam implements Serializable {

    private static final long serialVersionUID = -4004586460484111481L;

    private String loginAccount;

    private String password;

    private String mobile;

    private String email;

    private String verifyCode;

    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }
}