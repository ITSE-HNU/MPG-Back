package com.ghstudio.pairprogram.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ResultEnum 预定义错误返回
 */
@Getter
@AllArgsConstructor
public enum ResultEnum {
    SUCCESS(0, "请求成功"),
    DEFAULT_ERROR(10001, "请求失败"),
    ARGUMENT_ERROR(10002, "参数错误"),
    SIGN_TOKEN_ERROR(10003, "生成签名失败"),
    PASSWORD_ERROR(20001, "密码错误"),
    USER_NOT_FOUND(20002, "用户未找到"),
    AUTH_ERROR(20003, "权限不满足"),
    PARSE_TOKEN_ERROR(20004, "Token 解析失败"),
    JSON_PARSE_ERROR(20005, "json解析失败"),
    Message_Send_Error(20006, "信息发送失败"),
    Record_Existed(2007, "记录已存在");

    private int code;
    private String msg;
}
