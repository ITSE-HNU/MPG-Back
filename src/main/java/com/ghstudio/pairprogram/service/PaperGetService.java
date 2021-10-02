package com.ghstudio.pairprogram.service;

import com.ghstudio.pairprogram.service.entity.PaperResponseBody;

/**
 * PaperGetService 试卷获取请求接口
 */
public interface PaperGetService {
    /**
     * getPaper 获取试卷
     *
     * @param count 题目数量
     * @param role  学历
     * @return PaperResponseBody
     */
    PaperResponseBody getPaper(Integer count, Integer role);
}
