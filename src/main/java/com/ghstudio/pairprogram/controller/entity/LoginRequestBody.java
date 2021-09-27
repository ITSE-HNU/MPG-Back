package com.ghstudio.pairprogram.controller.entity;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * LoginRequestBody 请求体参数定义 用户名 密码
 */
@Data
public class LoginRequestBody {
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
}
