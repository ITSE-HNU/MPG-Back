package com.ghstudio.pairprogram.controller.entity;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * UserRequestBody 用户操作的请求参数 增删改查
 */
public class UserRequestBody {
    @Data
    public static class AddUserRequestBody {
        @NotEmpty
        private String username;
        @NotEmpty
        private String nickname;
        @NotEmpty
        private String password;
        @NotNull
        private Integer roleId;
    }

    @Data
    public static class UpdateUserRequestBody {
        @NotNull
        private Integer id;
        private String username;
        private String nickname;
        private String password;
        private Integer roleId;
    }

    @Data
    public static class ChangePasswdRequestBody {
        @NotEmpty
        private String newPassword;
    }

    @Data
    public static class DeleteUserRequestBody {
        @NotNull
        private Integer id;
    }
}
