package com.ghstudio.pairprogram.util;

import com.ghstudio.pairprogram.dao.entity.Verify;

import java.util.Date;

/**
 * VerifyUtil 验证码时间校验工具
 */
public class VerifyUtil {
    /**
     * verifyPeriod 验证验证码是否过期
     *
     * @param verify 验证码
     * @return boolean
     */
    public static boolean verifyPeriod(Verify verify) {
        Date createdAt = verify.getCreatedAt();
        long current = System.currentTimeMillis();
        long created = FormatDate.getTimeMillSeconds(FormatDate.getFormatDateTime(createdAt));
        return (current - created) / 1000 / 60 <= 5;
    }
}
