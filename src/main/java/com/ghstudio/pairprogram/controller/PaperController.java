package com.ghstudio.pairprogram.controller;

import com.ghstudio.pairprogram.service.PaperGetService;
import com.ghstudio.pairprogram.service.entity.PaperResponseBody;
import com.ghstudio.pairprogram.util.Result;
import com.ghstudio.pairprogram.util.ResultEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * PaperController 试卷分发控制器
 */
@RestController
public class PaperController {
    private final Logger logger = LoggerFactory.getLogger(RegisterController.class);

    @Resource
    PaperGetService paperGetService;

    /**
     * getPaper 获取试卷
     *
     * @param count 题目数量
     * @param role  学历
     * @return PaperResponseBody 试卷
     */
    @PostMapping("/question")
    public Result<PaperResponseBody> getPaper(@RequestParam(value = "count") Integer count,
                                              @RequestParam(value = "role") Integer role) {
        try {
            PaperResponseBody result = paperGetService.getPaper(count, role);
            return Result.success(result);
        } catch (Exception e) {
            logger.warn("Exception", e);
            return Result.error(ResultEnum.DEFAULT_ERROR);
        }
    }
}