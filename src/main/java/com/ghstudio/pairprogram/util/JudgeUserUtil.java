package com.ghstudio.pairprogram.util;

public class JudgeUserUtil {
    private static final int rootAuth = 1;
    private static final int normalAuth = 1 << 2;

    public static boolean isNormal(int auth) {
        return (JudgeUserUtil.normalAuth & auth) != 0;
    }
}
