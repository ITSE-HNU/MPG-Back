package com.ghstudio.pairprogram.service;

import com.ghstudio.pairprogram.exception.MessageSendFailedException;
import com.ghstudio.pairprogram.exception.RecordExistedException;

/**
 * RegisterService 注册服务接口
 */
public interface RegisterService {
    /**
     * SendVerificationCode 发送验证码
     *
     * @param phone 电话号码
     * @throws MessageSendFailedException 短信发送失败
     * @throws RecordExistedException     记录已存在且未使用且未超时 防止恶意访问
     */
    void SendVerificationCode(String phone) throws MessageSendFailedException, RecordExistedException;
}
