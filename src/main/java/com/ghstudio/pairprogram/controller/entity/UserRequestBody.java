package com.ghstudio.pairprogram.controller.entity;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * UserRequestBody 用户操作的请求参数 增删改查
 */
public class UserRequestBody {
    @Data
    public static class AddUserRequestBody {
        @NotEmpty
        private String username;
        @NotEmpty
        private String password;
    }

    @Data
    public static class ChangePasswdRequestBody {
        @NotEmpty
        private String newPassword;
    }
}
