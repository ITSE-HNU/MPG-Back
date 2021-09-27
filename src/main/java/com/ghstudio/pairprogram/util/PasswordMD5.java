package com.ghstudio.pairprogram.util;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * PasswordMD5 MD5 加密工具
 */
public class PasswordMD5 {
    /**
     * getPasswordMD5 获取 MD5 加密之后的密码
     *
     * @param password 传入代价密的密码
     * @return String 加密之后的 Password
     */
    public static String getPasswordMD5(String password) {
        if (password == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(password.getBytes(StandardCharsets.UTF_8));
            byte[] result = messageDigest.digest();

            return new BigInteger(1, result).toString(16);
        } catch (NoSuchAlgorithmException e) {
            return "";
        }
    }
}
