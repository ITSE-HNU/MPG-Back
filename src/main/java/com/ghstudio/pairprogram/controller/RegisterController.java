package com.ghstudio.pairprogram.controller;

import com.ghstudio.pairprogram.controller.entity.RegisterRequestBody;
import com.ghstudio.pairprogram.controller.entity.VerifyCodeRequestBody;
import com.ghstudio.pairprogram.exception.*;
import com.ghstudio.pairprogram.service.RegisterService;
import com.ghstudio.pairprogram.util.Result;
import com.ghstudio.pairprogram.util.ResultEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * RegisterController 用户注册 Controller
 */
@RestController
public class RegisterController {
    private final Logger logger = LoggerFactory.getLogger(RegisterController.class);

    @Resource
    private RegisterService registerService;

    /**
     * Register 注册
     *
     * @return null
     */
    @PostMapping("/register")
    public Result<?> Register(@Valid @RequestBody RegisterRequestBody req) {
        try {
            registerService.userRegister(req);
            return Result.success(null);
        } catch (VerifyCodeExpired e) {
            logger.warn("VerifyCodeExpired", e);
            return Result.error(ResultEnum.Verify_Code_Expired);
        } catch (UserExistedException e) {
            logger.warn("UserExisted", e);
            return Result.error(ResultEnum.User_Found_Exists);
        } catch (VerifyCodeNotMatchException e) {
            logger.warn("VerifyCodeNotMatch", e);
            return Result.error(ResultEnum.Verify_Code_Not_Match);
        } catch (VerifyNotFoundException e) {
            logger.warn("VerifyNotFound", e);
            return Result.error(ResultEnum.Verify_Code_Not_Found);
        } catch (Exception e) {
            logger.warn("Exception", e);
            return Result.error(ResultEnum.DEFAULT_ERROR);
        }
    }

    /**
     * SendRegisterCode 发送验证码
     *
     * @param req 请求参数 电话号码
     * @return null（不出错）
     */
    @PostMapping("/verify")
    public Result<?> SendRegisterCode(@Valid @RequestBody VerifyCodeRequestBody req) {
        try {
            registerService.sendVerificationCode(req.getPhoneNumber());
            return Result.success(null);
        } catch (MessageSendFailedException e) {
            logger.warn("MessageSendFailed", e);
            return Result.error(ResultEnum.Message_Send_Error);
        } catch (RecordExistedException e) {
            logger.warn("RecordExisted", e);
            return Result.error(ResultEnum.Record_Existed);
        } catch (Exception e) {
            logger.warn("Exception", e);
            return Result.error(ResultEnum.DEFAULT_ERROR);
        }
    }
}
