package com.ghstudio.pairprogram.util;

import com.ghstudio.pairprogram.dao.entity.Verify;

import java.util.Date;

public class VerifyUtil {
    public static boolean verifyPeriod(Verify verify) {
        Date createdAt = verify.getCreatedAt();
        long current = System.currentTimeMillis();
        long created = FormatDate.getTimeMillSeconds(FormatDate.getFormatDateTime(createdAt));
        return (current - created) / 1000 / 60 <= 5;
    }
}
