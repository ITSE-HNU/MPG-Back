package com.ghstudio.pairprogram.service.impl;

import com.ghstudio.pairprogram.dao.entity.Verify;
import com.ghstudio.pairprogram.dao.repository.VerifyRepository;
import com.ghstudio.pairprogram.exception.MessageSendFailedException;
import com.ghstudio.pairprogram.exception.RecordExistedException;
import com.ghstudio.pairprogram.service.RegisterService;
import com.ghstudio.pairprogram.util.SendMessage;
import com.ghstudio.pairprogram.util.VerifyUtil;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * RegisterImpl 注册接口实现
 */
@Component
public class RegisterImpl implements RegisterService {
    @Resource
    VerifyRepository verifyRepository;


    /**
     * SendVerificationCode 发送验证码
     *
     * @param phone 电话号码
     * @throws MessageSendFailedException 短信发送失败
     * @throws RecordExistedException     记录已存在且未使用且未超时 防止恶意访问
     */
    @Override
    public void SendVerificationCode(String phone) throws MessageSendFailedException, RecordExistedException {
        Verify verify = verifyRepository.getCodeByPhone(phone);
        if (verify != null) {
            if (!VerifyUtil.verifyPeriod(verify)) {
                throw new RecordExistedException();
            }
        }
        String[] messageParams = new String[2];
        messageParams[0] = SendMessage.generateVerificationCode();
        messageParams[1] = "5";
        verifyRepository.createVerify(Verify.builder().
                code(messageParams[0]).
                phone(phone).
                build());
        boolean response = SendMessage.sendMessage(phone, messageParams);
        if (!response) {
            throw new MessageSendFailedException();
        }
    }
}
