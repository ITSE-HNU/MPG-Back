package com.ghstudio.pairprogram.service.entity;

import lombok.Builder;
import lombok.Data;

/**
 * LoginResponseBody 登陆请求返回体定义: token id username role
 */
@Data
@Builder
public class LoginResponseBody {
    private String token;
    private int id;
    private String username;
}
