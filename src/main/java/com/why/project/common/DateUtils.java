package com.why.project.common;

import java.util.Calendar;

/**
 * 日期类
 * @author Mao
 */
public class DateUtils {
    private static Calendar calendar = Calendar.getInstance();

    /**
     * 获取月份 格式01,02
     * @return
     */
    public static String getMonth() {
        int month = calendar.get(Calendar.MONTH) + 1;
        return month < 10 ? "0" + month : month + "";
    }

    /**
     * 获取年份
     * @return
     */
    public static String getYear() {
        return calendar.get(Calendar.YEAR)+"";
    }


}
