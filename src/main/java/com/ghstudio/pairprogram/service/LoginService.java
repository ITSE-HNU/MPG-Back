package com.ghstudio.pairprogram.service;


import com.ghstudio.pairprogram.exception.PasswordErrorException;
import com.ghstudio.pairprogram.exception.UserNotFoundException;
import com.ghstudio.pairprogram.service.entity.LoginResponseBody;

public interface LoginService {
    LoginResponseBody UserLoginService(String username, String password)
            throws PasswordErrorException, UserNotFoundException;
}
