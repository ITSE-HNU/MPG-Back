package com.ghstudio.pairprogram.dao.repository;


import com.ghstudio.pairprogram.dao.entity.Verify;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface VerifyRepository {
    Verify getCodeByPhone(String phone);

    void createVerify(Verify verify);
}
