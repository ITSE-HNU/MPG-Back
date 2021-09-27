package com.ghstudio.pairprogram.service;


import com.ghstudio.pairprogram.exception.PasswordErrorException;
import com.ghstudio.pairprogram.exception.UserNotFoundException;
import com.ghstudio.pairprogram.service.entity.LoginResponseBody;

/**
 * LoginService 登陆服务接口
 */
public interface LoginService {
    /**
     * UserLoginService 用户登陆接口
     *
     * @param username 用户名
     * @param password 密码
     * @return LoginResponseBody 用户登陆请求返回体
     * @throws PasswordErrorException 密码错误
     * @throws UserNotFoundException  用户不存在
     */
    LoginResponseBody UserLoginService(String username, String password)
            throws PasswordErrorException, UserNotFoundException;
}
