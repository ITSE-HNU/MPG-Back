package com.ghstudio.pairprogram.service.impl;


import com.ghstudio.pairprogram.dao.entity.User;
import com.ghstudio.pairprogram.dao.repository.UserRepository;
import com.ghstudio.pairprogram.exception.PasswordErrorException;
import com.ghstudio.pairprogram.exception.SignTokenException;
import com.ghstudio.pairprogram.exception.UserNotFoundException;
import com.ghstudio.pairprogram.service.LoginService;
import com.ghstudio.pairprogram.service.entity.LoginResponseBody;
import com.ghstudio.pairprogram.util.PasswordMD5;
import com.ghstudio.pairprogram.util.Token;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * LoginImpl 登陆接口实现
 */
@Component
public class LoginImpl implements LoginService {
    @Resource
    UserRepository userRepository;

    @Resource
    Token token;

    /**
     * UserLoginService 用户登陆接口
     *
     * @param username 用户名
     * @param password 密码
     * @return LoginResponseBody 用户登陆请求返回体
     * @throws PasswordErrorException 密码错误
     * @throws UserNotFoundException  用户不存在
     */
    @Override
    public LoginResponseBody UserLoginService(String username, String password)
            throws PasswordErrorException, UserNotFoundException, SignTokenException {
        User user = userRepository.getUserByUsername(username);
        // 用户没有找到
        if (user == null) {
            throw new UserNotFoundException();
        }

        // 密码错误
        if (!user.getPassword().equals(PasswordMD5.getPasswordMD5(password))) {
            throw new PasswordErrorException();
        }

        String token;
        try {
            token = this.token.sign(user.getId());
        } catch (Exception e) {
            e.printStackTrace();
            throw new SignTokenException();
        }

        return LoginResponseBody.builder().
                id(user.getId()).
                token(token).
                username(user.getUsername()).
                role(user.getRole().getValue()).
                build();
    }
}
