package com.ghstudio.pairprogram.service;

/**
 * UserDealService 用户操作接口
 */
public interface UserDealService {
    /**
     * changeOwnPasswordService 更换密码
     *
     * @param id          当前用户 id
     * @param newPassword 新密码
     */
    void changeOwnPasswordService(int id, String newPassword);
}
