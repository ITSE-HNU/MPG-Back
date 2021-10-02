package com.ghstudio.pairprogram.dao.repository;

import com.ghstudio.pairprogram.dao.entity.Title;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * TitleRepository 试题操作 Mapper 接口
 */
@Repository
@Mapper
public interface TitleRepository {
    /**
     * queryTitles 查询题目
     *
     * @param params 题目 id
     * @return List of title
     */
    List<Title> queryTitles(List<Integer> params);
}
