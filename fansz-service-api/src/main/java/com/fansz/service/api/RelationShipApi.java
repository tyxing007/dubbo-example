package com.fansz.service.api;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.fansz.common.provider.model.CommonPagedResult;
import com.fansz.common.provider.model.CommonResult;
import com.fansz.common.provider.model.NullResult;
import com.fansz.service.extension.DubboxService;
import com.fansz.service.model.relationship.*;
import com.fansz.service.model.relationship.FriendsQueryParam;

import javax.ws.rs.*;

/**
 * 关系服务
 */
@Path("/relationships")
@Consumes(ContentType.APPLICATION_JSON_UTF_8)
@Produces(ContentType.APPLICATION_JSON_UTF_8)
public interface RelationShipApi {


    /**
     * 获取用户的好友列表
     *
     * @return resp 返回对象
     */
    @POST
    @Path("/friends/show")
    @DubboxService("getFriends")
    CommonPagedResult<FriendInfoResult> getFriends(FriendsQueryParam friendsParam);

    /**
     * 获取特别用户好友列表
     *
     * @return resp 返回对象
     */
    @POST
    @Path("/specialFriends/show")
    @DubboxService("getSpecialFriend")
    CommonPagedResult<FriendInfoResult> getSpecialFriends(FriendsQueryParam friendsParam);

    /**
     * 请求添加为好友
     *
     * @param addFriendParam
     * @return
     */
    @POST
    @Path("/friends/add")
    @DubboxService("requestToBeFriends")
    CommonResult<NullResult> addFriendRequest(AddFriendParam addFriendParam);

    /**
     * 添加为特别好友
     *
     * @param addFriendParam
     * @return
     */
    @POST
    @Path("/specialfriends/add")
    @DubboxService("beMySpecialFriend")
    CommonResult<NullResult> addSpecialFriend(AddFriendParam addFriendParam);

    /**
     * 取消特别好友
     *
     * @param addFriendParam
     * @return
     */
    @POST
    @Path("/specialfriends/cancel")
    @DubboxService("removeMySpecialFriend")
    CommonResult<NullResult> cancelSpecialFriend(AddFriendParam addFriendParam);

    /**
     * 同意添加好友
     *
     * @param opRequestParam
     * @return
     */
    @POST
    @Path("/friends/agree")
    @DubboxService("agreeAddRequest")
    CommonResult<NullResult> agreeRequest(OpRequestParam opRequestParam);


    /**
     * 获取添加我的好友请求
     *
     * @param friendsQueryParam
     * @return
     */
    @POST
    @Path("/friends/requestMe")
    @DubboxService("getFriendRequests")
    CommonPagedResult<FriendInfoResult> getFriendRquests(FriendsQueryParam friendsQueryParam);

    /**
     * 获取我发出的好友请求列表
     *
     * @param friendsQueryParam
     * @return
     */
    @POST
    @Path("/friends/myRequest")
    @DubboxService("getRequesters")
    CommonPagedResult<FriendInfoResult> getRequesters(FriendsQueryParam friendsQueryParam);
}