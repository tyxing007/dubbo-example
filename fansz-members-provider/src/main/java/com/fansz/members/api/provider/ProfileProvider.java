package com.fansz.members.api.provider;

import com.fansz.members.api.ProfileApi;
import com.fansz.members.api.extension.AbstractProvider;
import com.fansz.members.api.service.ProfileService;
import com.fansz.members.model.CommonPagedResult;
import com.fansz.members.model.search.SearchParam;
import com.fansz.members.tools.Constants;
import com.fansz.members.exception.ApplicationException;
import com.fansz.members.model.CommonResult;
import com.fansz.members.model.NullResult;
import com.fansz.members.model.profile.*;
import com.fansz.members.tools.StringTools;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 配置服务提供者
 * TODO:后续需要进行重构,统一处理过程,分为权限控制,参数检查,调用服务等
 */
@Component("profileProvider")
public class ProfileProvider extends AbstractProvider implements ProfileApi {

    private final static NullResult PRESENCE = new NullResult();

    @Autowired
    private ProfileService profileService;

    /**
     * 获取当前登陆用户的详细信息
     *
     * @param queryUserParam
     * @return
     */
    @Override
    public CommonResult<UserInfoResult> getProfile(QueryProfileParam queryUserParam) {
        UserInfoResult userInfoResult = profileService.getProfile(queryUserParam.getUid());
        return renderSuccess(userInfoResult, "Get profile successfully");
    }

    @Override
    public CommonPagedResult<UserInfoResult> searchMembers(SearchParam searchParam) {
        PageList<UserInfoResult> data = profileService.searchMembers(searchParam);
        return renderPagedSuccess(data);
    }

    /**
     * 修改当前用户的配置信息
     *
     * @param modifyProfileParam
     * @return
     */
    @Override
    public CommonResult<NullResult> modifyProfile(ModifyProfileParam modifyProfileParam) {
        profileService.modifyProfile(modifyProfileParam);
        return renderSuccess(PRESENCE, "Change profile successfully");
    }

    @Override
    public CommonResult<UserInfoResult> getProfileByNickname(ModifyProfileParam modifyProfileParam) {
        profileService.getProfileByNickname(modifyProfileParam);
        return null;
    }

    @Override
    public CommonPagedResult<ContactInfoResult> getContactInfo(ContactQueryParam contractQueryParam) {
        PageList<ContactInfoResult> dataResult = profileService.findRelationByMobiles(contractQueryParam);
        return super.renderPagedSuccess(dataResult);
    }
}