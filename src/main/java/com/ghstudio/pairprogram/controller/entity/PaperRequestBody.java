package com.ghstudio.pairprogram.controller.entity;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * PaperRequestBody 试卷分发请求参数 用户学历 题目数量
 */
@Data
public class PaperRequestBody {
    /**
     * role 职能/学历  1: 小学  2: 初中 3: 高中
     */
    @NotEmpty
    private Integer role;

    @NotEmpty
    private Integer count;
}
