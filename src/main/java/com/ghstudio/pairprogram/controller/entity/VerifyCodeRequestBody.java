package com.ghstudio.pairprogram.controller.entity;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * VerifyCodeRequestBody 验证码请求体 电话号码
 */
@Data
public class VerifyCodeRequestBody {
    @NotEmpty
    private String phoneNumber;
}
