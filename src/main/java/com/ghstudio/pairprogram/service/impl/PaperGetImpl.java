package com.ghstudio.pairprogram.service.impl;

import com.ghstudio.pairprogram.dao.entity.Title;
import com.ghstudio.pairprogram.dao.repository.TitleRepository;
import com.ghstudio.pairprogram.service.PaperGetService;
import com.ghstudio.pairprogram.service.entity.PaperResponseBody;
import com.ghstudio.pairprogram.util.IndexGenerate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * PaperGetImpl 试卷分发请求接口实现
 */
@Component
public class PaperGetImpl implements PaperGetService {
    @Resource
    TitleRepository titleRepository;

    /**
     * getPaper 获取试卷
     *
     * @param count 题目数量
     * @param role  学历
     * @return PaperResponseBody
     */
    @Override
    public PaperResponseBody getPaper(Integer count, Integer role) {
        List<Integer> ids = IndexGenerate.generateIndex(count, role);
        List<Title> result = titleRepository.queryTitles(ids);
        PaperResponseBody.PaperResponseBodyBuilder paperResponseBodyBuilder = PaperResponseBody.builder();
        paperResponseBodyBuilder.count(count);

        List<PaperResponseBody.Title> titleList = new ArrayList<>();

        AtomicInteger i = new AtomicInteger();
        i.getAndIncrement();
        result.forEach(item -> {
            PaperResponseBody.Title.TitleBuilder titleBuilder = PaperResponseBody.Title.builder();
            titleBuilder.id(i.getAndIncrement()).
                    question(item.getQuestion()).
                    choiceA(item.getChoiceA()).
                    choiceB(item.getChoiceB()).
                    choiceC(item.getChoiceC()).
                    choiceD(item.getChoiceD()).
                    answer(item.getCorrect());
            titleList.add(titleBuilder.build());
        });

        paperResponseBodyBuilder.titles(titleList);

        return paperResponseBodyBuilder.build();
    }
}
