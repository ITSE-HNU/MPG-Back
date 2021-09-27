package com.ghstudio.pairprogram.util;

/**
 * JudgeUserUtil 用户权限判断工具
 */
public class JudgeUserUtil {
    private static final int rootAuth = 1;
    private static final int normalAuth = 1 << 2;

    /**
     * isNormal 判断用户是否是 normal 权限
     *
     * @param auth 待检测权限
     * @return boolean
     */
    public static boolean isNormal(int auth) {
        return (JudgeUserUtil.normalAuth & auth) != 0;
    }
}
