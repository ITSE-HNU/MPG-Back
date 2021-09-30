package com.ghstudio.pairprogram.service.impl;

import com.ghstudio.pairprogram.dao.entity.User;
import com.ghstudio.pairprogram.dao.repository.UserRepository;
import com.ghstudio.pairprogram.service.UserDealService;
import com.ghstudio.pairprogram.util.PasswordMD5;

import javax.annotation.Resource;

/**
 * UserDealImpl 用户操作接口实现
 */
public class UserDealImpl implements UserDealService {
    @Resource
    UserRepository userRepository;

    /**
     * changeOwnPasswordService 更换密码
     *
     * @param id          当前用户 id
     * @param newPassword 新密码
     */
    @Override
    public void changeOwnPasswordService(int id, String newPassword) {
        User.UserBuilder builder = User.builder();
        User updateUser = builder.id(id).password(PasswordMD5.getPasswordMD5(newPassword)).build();

        userRepository.updateUser(updateUser);
    }
}
