package com.ghstudio.pairprogram.service.impl;

import com.ghstudio.pairprogram.exception.MessageSendFailedException;
import com.ghstudio.pairprogram.exception.RecordExistedException;
import com.ghstudio.pairprogram.service.RegisterService;
import com.ghstudio.pairprogram.util.SendMessage;
import org.springframework.stereotype.Component;

/**
 * RegisterImpl 注册接口实现
 */
@Component
public class RegisterImpl implements RegisterService {
    /**
     * SendVerificationCode 发送验证码
     *
     * @param phone 电话号码
     * @throws MessageSendFailedException 短信发送失败
     * @throws RecordExistedException     记录已存在且未使用且未超时 防止恶意访问
     */
    @Override
    public void SendVerificationCode(String phone) throws MessageSendFailedException, RecordExistedException {
        String[] messageParams = new String[2];
        messageParams[0] = SendMessage.generateVerificationCode();
        messageParams[1] = "5";
        boolean response = SendMessage.sendMessage(phone, messageParams);
        if (!response) {
            throw new MessageSendFailedException();
        }
    }
}
