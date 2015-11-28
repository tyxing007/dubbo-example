package com.fansz.members.api.provider;

import com.fansz.members.api.VerifyCodeApi;
import com.fansz.members.api.service.VerifyCodeService;
import com.fansz.members.api.utils.Constants;
import com.fansz.members.api.utils.VerifyCodeType;
import com.fansz.members.model.CommonResult;
import com.fansz.members.model.NullResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.PathParam;

/**
 * 验证码服务提供者
 *
 * @author yanyanming
 */
@Component("verifyCodeProvider")
public class VerifyCodeProvider implements VerifyCodeApi {

    @Autowired
    private VerifyCodeService verifyCodeService;

    /**
     * 获取忘记密码验证码接口
     *
     * @param mobile 手机号码
     * @return resp 返回对象
     */
    public CommonResult<NullResult> getVerifyCodeForReset(@PathParam("mobile") String mobile) {
        CommonResult<NullResult> result = new CommonResult<>();
        result.setStatus(Constants.SUCCESS);
        verifyCodeService.createVerifyCode(mobile, VerifyCodeType.RESET);
        return result;

    }

    /**
     * 获取注册验证码接口
     *
     * @param mobile 手机号码
     * @return resp 返回对象
     */
    public CommonResult<NullResult> getVerifyCodeForRegister(@PathParam("mobile") String mobile) {
        CommonResult<NullResult> result = new CommonResult<>();
        result.setStatus(Constants.SUCCESS);
        verifyCodeService.createVerifyCode(mobile, VerifyCodeType.REGISTER);
        return result;
    }

}