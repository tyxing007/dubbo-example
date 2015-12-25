package com.fansz.service.api;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.fansz.common.provider.model.CommonResult;
import com.fansz.common.provider.model.NullResult;
import com.fansz.service.extension.DubboxService;
import com.fansz.service.model.specialfocus.ModifySpecialFocusParam;
import com.fansz.service.model.specialfocus.SpecialFocusParam;
import com.fansz.service.model.specialfocus.SpecialFocusResult;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

/**
 * 特别关注
 * Created by dell on 2015/12/9.
 */
@Path("/specialfocus")
@Consumes(ContentType.APPLICATION_JSON_UTF_8)
@Produces(ContentType.APPLICATION_JSON_UTF_8)
public interface SpecialFocusApi {
    /**
     *获取某人特别关注的好友和圈子信息
     * @param specialFocusParam
     * @return
     */
    @POST
    @Path("/getInfo")
    @DubboxService("getAllSpecialFocus")
    CommonResult<List<SpecialFocusResult>> getSpecialFocusInfo(SpecialFocusParam specialFocusParam);

    /**
     * 添加特别关注关联信息
     * @param specialFocusParam
     * @return
     */
    @POST
    @Path("/add")
    CommonResult<NullResult> addSpecialFocusInfo(SpecialFocusParam specialFocusParam);

    /**
     * 修改特别关注关联信息
     * @param specialFocusParam
     * @return
     */
    @POST
    @Path("/modify")
    @DubboxService("setSpecialFocusOrder")
    CommonResult<NullResult> modifySpecialFocusInfo(ModifySpecialFocusParam specialFocusParam);

    /**
     * 删除特别关注关联信息
     * @param specialFocusParam
     * @return
     */
    @POST
    @Path("/del")
    CommonResult<NullResult> delSpecialFocusInfo(SpecialFocusParam specialFocusParam);

}