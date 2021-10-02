package com.ghstudio.pairprogram.controller.entity;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * UserRequestBody 用户操作的请求参数 增删改查
 */
public class UserRequestBody {
    /**
     * ChangePasswdRequestBody 密码更换请求体  新密码
     */
    @Data
    public static class ChangePasswdRequestBody {
        @NotEmpty
        private String newPassword;
    }
}
