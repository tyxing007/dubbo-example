package com.fansz.relations.api;


import com.fansz.common.provider.annotation.DubboxMethod;
import com.fansz.common.provider.annotation.DubboxService;
import com.fansz.common.provider.exception.ApplicationException;
import com.fansz.common.provider.model.CommonPagedResult;
import com.fansz.common.provider.model.CommonResult;
import com.fansz.common.provider.model.NullResult;
import com.fansz.relations.model.*;

/**
 * 关系服务
 */
@DubboxService("relations")
public interface RelationShipApi {


    /**
     * 获取用户的好友列表
     *
     * @return resp 返回对象
     */
    @DubboxMethod("getFriends")
    CommonPagedResult<FriendInfoResult> getFriends(FriendsQueryParam friendsParam) throws ApplicationException;

    /**
     * C020:获取特别用户好友列表
     *
     * @return resp 返回对象
     */
    @DubboxMethod("getSpecialFriend")
    CommonPagedResult<FriendInfoResult> getSpecialFriends(FriendsQueryParam friendsParam) throws ApplicationException;

    /**
     * 请求添加为好友
     *
     * @param addFriendParam
     * @return
     */
    @DubboxMethod("requestToBeFriends")
    CommonResult<NullResult> addFriendRequest(AddFriendParam addFriendParam) throws ApplicationException;

    /**
     * 添加为特别好友
     *
     * @param addFriendParam
     * @return
     */
    @DubboxMethod("beMySpecialFriend")
    CommonResult<NullResult> addSpecialFriend(AddFriendParam addFriendParam) throws ApplicationException;

    /**
     * 取消特别好友
     *
     * @param addFriendParam
     * @return
     */
    @DubboxMethod("removeMySpecialFriend")
    CommonResult<NullResult> cancelSpecialFriend(AddFriendParam addFriendParam) throws ApplicationException;

    /**
     * 同意添加好友
     *
     * @param opRequestParam
     * @return
     */
    @DubboxMethod("agreeAddRequest")
    CommonResult<NullResult> agreeRequest(OpRequestParam opRequestParam) throws ApplicationException;


    /**
     * 获取添加我的好友请求
     *
     * @param friendsQueryParam
     * @return
     */
    @DubboxMethod("getFriendRequests")
    CommonPagedResult<FriendInfoResult> getFriendRquests(FriendsQueryParam friendsQueryParam) throws ApplicationException;

    /**
     * C019:获取我发出的好友请求列表
     *
     * @param friendsQueryParam
     * @return
     */
    @DubboxMethod("getRequesters")
    CommonPagedResult<FriendInfoResult> getRequesters(FriendsQueryParam friendsQueryParam) throws ApplicationException;

    /**
     * 上传用户通讯录，搜索出通讯录好友（包含好友状态）
     */
    @DubboxMethod("searchContacts")
    CommonPagedResult<FriendInfoResult> getContactInfo(ContactQueryParam contractQueryParam) throws ApplicationException;


}