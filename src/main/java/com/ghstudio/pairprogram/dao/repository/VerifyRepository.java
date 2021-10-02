package com.ghstudio.pairprogram.dao.repository;


import com.ghstudio.pairprogram.dao.entity.Verify;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * VerifyRepository 验证码操作 Mapper 接口
 */
@Repository
@Mapper
public interface VerifyRepository {
    /**
     * getCodeByPhone 根据手机号获取验证码
     *
     * @param phone 手机号
     * @return Verify
     */
    Verify getCodeByPhone(String phone);

    /**
     * createVerify 创建新的验证码记录
     *
     * @param verify 验证码
     */
    void createVerify(Verify verify);
}
