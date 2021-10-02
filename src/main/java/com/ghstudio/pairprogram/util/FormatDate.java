package com.ghstudio.pairprogram.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * FormatDate 时间格式化
 */
public class FormatDate {
    /**
     * getFormatDate 日期格式化
     *
     * @param date 传入的 date 对象
     * @return String 格式化之后的字符串
     */
    public static String getFormatDate(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(date);
    }

    /**
     * getFormatDateTime 日期时间格式化
     *
     * @param date 传入的 date 对象
     * @return String 格式化之后的字符串
     */
    public static String getFormatDateTime(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);
    }

    public static long getTimeMillSeconds(String date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long result = -1;
        try {
            result = simpleDateFormat.parse(date).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }
}
