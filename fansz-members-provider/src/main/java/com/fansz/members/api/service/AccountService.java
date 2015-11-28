package com.fansz.members.api.service;

import com.fansz.members.model.RegisterResult;
import com.fansz.members.model.account.ChangePasswordParam;
import com.fansz.members.model.account.LoginParam;
import com.fansz.members.model.account.LoginResult;
import com.fansz.members.model.account.RegisterParam;

/**
 * Created by root on 15-11-3.
 */
public interface AccountService {

    public RegisterResult register(RegisterParam registerParam);


    /**
     * 修改密码
     *
     * @param changePasswordParam 修改密码对象
     */
    void changePassword(ChangePasswordParam changePasswordParam);

    /**
     * 重置密码
     *
     * @param resetPasswordParam 重置密码对象
     */
    void resetPassword(com.fansz.members.model.account.ResetPasswordParam resetPasswordParam);

    /**
     * 用户登陆
     *
     * @param loginParam
     * @return
     */
    LoginResult login(LoginParam loginParam);

    /**
     * 退出登陆
     *
     * @param uid
     */
    void logout(String uid);
}