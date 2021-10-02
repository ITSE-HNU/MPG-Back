package com.ghstudio.pairprogram.service.impl;

import com.ghstudio.pairprogram.controller.entity.RegisterRequestBody;
import com.ghstudio.pairprogram.dao.entity.User;
import com.ghstudio.pairprogram.dao.entity.Verify;
import com.ghstudio.pairprogram.dao.repository.UserRepository;
import com.ghstudio.pairprogram.dao.repository.VerifyRepository;
import com.ghstudio.pairprogram.exception.*;
import com.ghstudio.pairprogram.service.RegisterService;
import com.ghstudio.pairprogram.util.PasswordMD5;
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

    @Resource
    UserRepository userRepository;


    /**
     * sendVerificationCode 发送验证码
     *
     * @param phone 电话号码
     * @throws MessageSendFailedException 短信发送失败
     * @throws RecordExistedException     记录已存在且未使用且未超时 防止恶意访问
     */
    @Override
    public void sendVerificationCode(String phone) throws MessageSendFailedException, RecordExistedException {
        Verify verify = verifyRepository.getCodeByPhone(phone);
        if (verify != null) {
            if (VerifyUtil.verifyPeriod(verify)) {
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

    /**
     * userRegister 用户注册
     *
     * @param req 用户注册请求体
     * @throws UserExistedException 用户已存在
     * @throws VerifyCodeExpired    验证码过期
     */
    @Override
    public void userRegister(RegisterRequestBody req) throws UserExistedException, VerifyCodeExpired, VerifyCodeNotMatchException, VerifyNotFoundException {
        User user = userRepository.getUserByUsername(req.getPhoneNumber());
        if (user != null) {
            throw new UserExistedException();
        }
        Verify verify = verifyRepository.getCodeByPhone(req.getPhoneNumber());
        if (verify != null) {
            if (!VerifyUtil.verifyPeriod(verify)) {
                throw new VerifyCodeExpired();
            }
            if (!verify.getCode().equals(req.getVerifyCode())) {
                throw new VerifyCodeNotMatchException();
            }
            userRepository.addUser(User.builder().
                    username(req.getPhoneNumber()).
                    password(PasswordMD5.getPasswordMD5(req.getPassword())).
                    build());
            return;
        }
        throw new VerifyNotFoundException();
    }
}
