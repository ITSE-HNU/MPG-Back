package com.ghstudio.pairprogram.controller.entity;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * RegisterRequestBody 注册请求体参数定义 电话号码
 */
@Data
public class RegisterRequestBody {
    @NotEmpty
    private String phoneNumber;
}
