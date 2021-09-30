package com.ghstudio.pairprogram.dao.entity;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

/**
 * User 用户表定义
 */
@Data
@Builder
public class User {
    private int id;
    private String username;
    private String nickname;
    private String password;

    @Tolerate
    public User() {
    }
}
