package com.fansz.members.api.provider;

import com.fansz.members.api.service.ContactsService;
import com.fansz.members.api.utils.ErrorMessage;
import com.fansz.members.api.utils.ErrorParser;
import com.fansz.members.api.utils.StringUtils;
import com.fansz.members.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Vector;

/**
 * 好友关系接口类
 * Created by root on 15-11-3.
 */
@Service
@Component("/contactsProvider")
public class ContactsProvider {

    @Autowired
    private ErrorParser errorParser;

    @Autowired
    private ContactsService contactsService;

    /**
     * 添加好友接口
     * @param followId 好友用户
     * @return resp 返回对象
     */
    @POST
    @Path("/friend/add/{followId}")
    @Produces("application/json")
    public Response addFriend(@PathParam("followId") String followId)
    {
        Vector<ErrorMessage> errorMessages = new Vector<>();
        try {
            contactsService.addFriend(followId, followId);

        } catch (IllegalArgumentException iae) {
            errorMessages.add(errorParser.phase(iae.getMessage()));
        } catch (ConstraintViolationException cve) {
            errorMessages.addAll(errorParser.phase(cve.getConstraintViolations()));
        } catch (Exception e) {
            errorMessages.add(errorParser.phase("error.unknown"));
        }
        if (errorMessages.size() != 0) {
            return StringUtils.getErrorResponse(errorMessages);
        }
        else {
            return StringUtils.getSuccessResponse(0, null);
        }
    }

    /**
     * 接受添加接口
     * @param followId 好友用户id
     * @return resp 返回对象
     */
    @POST
    @Path("/friend/accept/{followId}")
    @Produces("application/json")
    public Response acceptFriend(@PathParam("followId") String followId)
    {
        Vector<ErrorMessage> errorMessages = new Vector<>();
        try {
             contactsService.acceptFriend(followId, followId);

        } catch (IllegalArgumentException iae) {
            errorMessages.add(errorParser.phase(iae.getMessage()));
        } catch (ConstraintViolationException cve) {
            errorMessages.addAll(errorParser.phase(cve.getConstraintViolations()));
        } catch (Exception e) {
            errorMessages.add(errorParser.phase("error.unknown"));
        }
        if (errorMessages.size() != 0) {
            return StringUtils.getErrorResponse(errorMessages);
        }
        else {
            return StringUtils.getSuccessResponse(0, null);
        }
    }

    /**
     * 删除好友接口
     * @param id 好友用户id
     * @return resp 返回对象
     */
    @POST
    @Path("/friend/{id}/remove")
    @Produces("application/json")
    public Response removeFriend(@PathParam("id") String id)
    {
        Vector<ErrorMessage> errorMessages = new Vector<>();
        try {
            contactsService.removeFriend(id, id);

        } catch (IllegalArgumentException iae) {
            errorMessages.add(errorParser.phase(iae.getMessage()));
        } catch (ConstraintViolationException cve) {
            errorMessages.addAll(errorParser.phase(cve.getConstraintViolations()));
        } catch (Exception e) {
            errorMessages.add(errorParser.phase("error.unknown"));
        }
        if (errorMessages.size() != 0) {
            return StringUtils.getErrorResponse(errorMessages);
        }
        else {
            return StringUtils.getSuccessResponse(0, null);
        }
    }

    /**
     * 获取我所有好友接口
     * @return resp 返回对象
     */
    @GET
    @Path("/friend")
    @Produces("application/json")
    public Response getFriends(String myId)
    {
        Vector<ErrorMessage> errorMessages = new Vector<>();
        List<User> friends = null;
        try {
            friends = contactsService.getFriends(myId);

        } catch (IllegalArgumentException iae) {
            errorMessages.add(errorParser.phase(iae.getMessage()));
        } catch (ConstraintViolationException cve) {
            errorMessages.addAll(errorParser.phase(cve.getConstraintViolations()));
        } catch (Exception e) {
            errorMessages.add(errorParser.phase("error.unknown"));
        }
        if (errorMessages.size() != 0) {
            return StringUtils.getErrorResponse(errorMessages);
        }
        else {
            return StringUtils.getSuccessResponse(0, friends);
        }
    }

    /**
     * 获取好友详细信息接口
     * @param id 好友用户id
     * @return resp 返回对象
     */
    @GET
    @Path("/friend/{id}")
    @Produces("application/json")
    public Response getFriendProfile(@PathParam("id") String id)
    {
        Vector<ErrorMessage> errorMessages = new Vector<>();
        User user = null;
        try {
            user = contactsService.getFriend(id, id);

        } catch (IllegalArgumentException iae) {
            errorMessages.add(errorParser.phase(iae.getMessage()));
        } catch (Exception e) {
            errorMessages.add(errorParser.phase("error.unknown"));
        }
        if (errorMessages.size() != 0) {
            return StringUtils.getErrorResponse(errorMessages);
        }
        else {
            return StringUtils.getSuccessResponse(0, user);
        }
    }

    /**
     * 搜索好友接口
     * @param string 查询条件
     * @return resp 返回对象
     */
    @POST
    @Path("/findnew")
    @Consumes("application/json")
    @Produces("application/json")
    public Response findFriend(String id, String string)
    {
        Vector<ErrorMessage> errorMessages = new Vector<>();
        List<User> users = null;
        try {
            users = contactsService.findFriend(id, string);

        } catch (IllegalArgumentException iae) {
            errorMessages.add(errorParser.phase(iae.getMessage()));
        } catch (Exception e) {
            errorMessages.add(errorParser.phase("error.unknown"));
        }
        if (errorMessages.size() != 0) {
            return StringUtils.getErrorResponse(errorMessages);
        }
        else {
            return StringUtils.getSuccessResponse(0, users);
        }
    }

    /**
     * 获取用户详细信息接口
     * @param id 用户id
     * @return resp 返回对象
     */
    @GET
    @Path("/user/{id}")
    @Produces("application/json")
    public Response getUserProfile(@PathParam("id") String id)
    {
        Vector<ErrorMessage> errorMessages = new Vector<>();
        User user = null;
        try {
            user = contactsService.getFriend(id, id);

        } catch (IllegalArgumentException iae) {
            errorMessages.add(errorParser.phase(iae.getMessage()));
        } catch (Exception e) {
            errorMessages.add(errorParser.phase("error.unknown"));
        }
        if (errorMessages.size() != 0) {
            return StringUtils.getErrorResponse(errorMessages);
        }
        else {
            return StringUtils.getSuccessResponse(0, user);
        }
    }

    /**
     * 获取所有候选人接口
     * @return resp 返回对象
     */
    @GET
    @Path("/follower/{id}")
    @Produces("application/json")
    public Response getFollowRequest(@PathParam("id") String id)
    {
        Vector<ErrorMessage> errorMessages = new Vector<>();
        List<User> user = null;
        try {
            user = contactsService.getCandidates(id);

        } catch (IllegalArgumentException iae) {
            errorMessages.add(errorParser.phase(iae.getMessage()));
        } catch (Exception e) {
            errorMessages.add(errorParser.phase("error.unknown"));
        }
        if (errorMessages.size() != 0) {
            return StringUtils.getErrorResponse(errorMessages);
        }
        else {
            if (null != user)
            {
                return StringUtils.getSuccessResponse(user.size(), user);
            }
            else
            {
                return StringUtils.getSuccessResponse(0, user);
            }

        }
    }
}
