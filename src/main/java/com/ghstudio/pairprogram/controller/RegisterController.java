package com.ghstudio.pairprogram.controller;

import com.ghstudio.pairprogram.controller.entity.RegisterRequestBody;
import com.ghstudio.pairprogram.exception.MessageSendFailedException;
import com.ghstudio.pairprogram.exception.RecordExistedException;
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

@RestController
public class RegisterController {
    private final Logger logger = LoggerFactory.getLogger(RegisterController.class);

    @Resource
    private RegisterService registerService;

    @PostMapping("/register")
    public Result<?> Register() {
        return Result.success(null);
    }

    @PostMapping("/verify")
    public Result<?> SendRegisterCode(@Valid @RequestBody RegisterRequestBody req) {
        try {
            registerService.SendVerificationCode(req.getPhoneNumber());
            return Result.success(null);
        } catch (MessageSendFailedException e) {
            logger.warn("MessageSendFailed", e);
            return Result.error(ResultEnum.Message_Send_Error);
        } catch (RecordExistedException e) {
            logger.warn("记录已经存在", e);
            return Result.error(ResultEnum.Record_Existed);
        } catch (Exception e) {
            logger.warn("Exception", e);
            return Result.error(ResultEnum.DEFAULT_ERROR);
        }

    }
}
