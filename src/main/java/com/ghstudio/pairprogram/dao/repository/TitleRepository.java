package com.ghstudio.pairprogram.dao.repository;

import com.ghstudio.pairprogram.dao.entity.Title;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TitleRepository {
    List<Title> queryTitles(List<Integer> params);
}
