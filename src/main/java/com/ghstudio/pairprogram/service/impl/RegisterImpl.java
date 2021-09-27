package com.ghstudio.pairprogram.service.impl;

import com.ghstudio.pairprogram.exception.MessageSendFailedException;
import com.ghstudio.pairprogram.exception.RecordExistedException;
import com.ghstudio.pairprogram.service.RegisterService;
import com.ghstudio.pairprogram.util.SendMessage;

public class RegisterImpl implements RegisterService {
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
