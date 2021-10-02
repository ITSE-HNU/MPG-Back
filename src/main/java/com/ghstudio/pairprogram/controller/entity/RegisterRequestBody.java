package com.ghstudio.pairprogram.controller.entity;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * RegisterRequestBody 注册请求体参数定义 电话号码 密码 验证码
 */
@Data
public class RegisterRequestBody {
    @NotEmpty
    private String phoneNumber;

    @NotEmpty
    private String password;

    @NotEmpty
    private String verifyCode;
}
