package com.ghstudio.pairprogram.dao.entity;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import java.util.Date;

/**
 * Verify 验证码定义
 */
@Data
@Builder
public class Verify {
    private int id;
    private String phone;
    private String code;
    private Date createdAt;

    @Tolerate
    public Verify() {
    }
}
