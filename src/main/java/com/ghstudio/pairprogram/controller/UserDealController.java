package com.ghstudio.pairprogram.controller;

import com.ghstudio.pairprogram.controller.entity.UserRequestBody;
import com.ghstudio.pairprogram.dao.entity.User;
import com.ghstudio.pairprogram.service.UserDealService;
import com.ghstudio.pairprogram.util.CurrentUser;
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
public class UserDealController {
    private final Logger logger = LoggerFactory.getLogger(UserDealController.class);

    @Resource
    UserDealService userDealService;

    @PostMapping("/changePwd")
    public Result<?> changeOwnPassword(@CurrentUser User user, @Valid @RequestBody UserRequestBody.ChangePasswdRequestBody req) {
        try {
            userDealService.changeOwnPasswordService(user.getId(), req.getNewPassword());
            return Result.success(null);
        } catch (Exception e) {
            logger.warn("Exception", e);
            return Result.error(ResultEnum.DEFAULT_ERROR);
        }
    }
}