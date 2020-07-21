package com.why.project.common;

import com.why.project.entity.Zwkmye2020;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mao
 */
public class MathUtils {

    /**
     * 多个BigDecimal数相加和
     *
     * @param arg
     * @return
     */
    public static BigDecimal getBigDecimalSum(BigDecimal... arg) {
        BigDecimal sum = new BigDecimal(0);
        for (BigDecimal b : arg) {
            sum = sum.add(b);
        }
        return sum;
    }

    /**
     * 借方发生
     * @param datas
     * @param course
     * @return
     */
    public static BigDecimal filterDataBorrow(List<Zwkmye2020> datas, String course) {
        return filter(datas, course).stream().map(Zwkmye2020::getZwkmyeJffs).reduce(BigDecimal.ZERO,BigDecimal::add);
    }

    /**
     * 贷方发生
     * @param datas
     * @param course
     * @return
     */
    public static BigDecimal filterDataLoan(List<Zwkmye2020> datas, String course) {
        return filter(datas, course).stream().map(Zwkmye2020::getZwkmyeDffs).reduce(BigDecimal.ZERO,BigDecimal::add);
    }

    /**
     * 到期余额
     * @param datas
     * @param course
     * @return
     */
    public static BigDecimal selectGather(List<Zwkmye2020> datas, String course) {
        return filter(datas, course).stream().map(Zwkmye2020::getZwkmyeDqye).reduce(BigDecimal.ZERO,BigDecimal::add);
    }

    /**
     *
     * @param datas
     * @param course
     * @return
     */

    private static List<Zwkmye2020> filter(List<Zwkmye2020> datas, String course) {
        return datas.stream().filter(s -> s.getZwkmyeKmbh().equals(course) && s.getZwkmyeKjq().equals(DateUtils.getMonth())).collect(Collectors.toList());
    }
}
