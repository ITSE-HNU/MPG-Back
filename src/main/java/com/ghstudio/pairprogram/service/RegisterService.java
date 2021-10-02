package com.ghstudio.pairprogram.service;

import com.ghstudio.pairprogram.controller.entity.RegisterRequestBody;
import com.ghstudio.pairprogram.exception.*;

/**
 * RegisterService 注册服务接口
 */
public interface RegisterService {
    /**
     * sendVerificationCode 发送验证码
     *
     * @param phone 电话号码
     * @throws MessageSendFailedException 短信发送失败
     * @throws RecordExistedException     记录已存在且未使用且未超时 防止恶意访问
     */
    void sendVerificationCode(String phone)
            throws MessageSendFailedException, RecordExistedException;

    /**
     * userRegister 用户注册
     *
     * @param req 用户注册请求体
     * @throws UserExistedException 用户已存在
     * @throws VerifyCodeExpired    验证码过期
     */
    void userRegister(RegisterRequestBody req)
            throws UserExistedException, VerifyCodeExpired, VerifyCodeNotMatchException, VerifyNotFoundException;
}
