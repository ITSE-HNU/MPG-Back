package com.ghstudio.pairprogram.service;

import com.ghstudio.pairprogram.exception.MessageSendFailedException;
import com.ghstudio.pairprogram.exception.RecordExistedException;

public interface RegisterService {
    void SendVerificationCode(String phone) throws MessageSendFailedException, RecordExistedException;
}
