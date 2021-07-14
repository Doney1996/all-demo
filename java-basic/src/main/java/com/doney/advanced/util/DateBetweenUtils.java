package com.doney.advanced.util;

import org.springframework.util.Assert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;


/**
 * 时间维度计算，某个时间区间，按照维度计算同比、环比
 * <p>
 * 支持
 *  <ul>
 *      <li>月    环比，同比
 *      <li>季度  环比，同比
 *      <li>年    环比，同比
 *  </ul>
 * </p>
 *
 * @author 欧东林 2020年12月22日
 * @see TimeTypeEnum 时间维度
 */
public class DateBetweenUtils {
    public final static DateTimeFormatter defaultFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public final static int now = 0;  //当前
    public final static int hb = 1;   // 环比
    public final static int tb = 2;   // 同比

    /**
     * 指定当前时间区间
     *
     * @param date     指定时间
     * @param timeType 时间类型枚举
     * @return DateBetween 时间开始、结束时间
     * @see TimeTypeEnum 时间维度
     */
    public static DateBetween getNow(LocalDate date, String timeType) {
        return getByTime(date, now, timeType);
    }

    /**
     * 指定时间环比区间
     *
     * @param date     指定时间
     * @param timeType 时间类型
     * @return DateBetween 时间开始、结束时间
     * @see TimeTypeEnum 时间类型枚举
     */
    public static DateBetween getHb(LocalDate date, String timeType) {
        return getByTime(date, hb, timeType);
    }

    /**
     * 指定时间同比区间
     *
     * @param date     指定时间
     * @param timeType 时间类型
     * @return DateBetween 时间开始、结束时间
     * @see TimeTypeEnum 时间类型枚举
     */
    public static DateBetween getTb(LocalDate date, String timeType) {
        return getByTime(date, tb, timeType);
    }

    /**
     * 根据不同时间点获取时间维度区间
     * @param date 当前时间
     * @param time 当前时间 同比时间 环比时间 类型
     * @param timeType 时间维度类型
     */
    private static DateBetween getByTime(LocalDate date, Integer time, String timeType) {
        Assert.isTrue(TimeTypeEnum.isValidName(timeType), "时间维度参数错误");
        if (tb == time) {//同比减去一年
            date = date.minusYears(1);
        }
        DateBetween dateBetween = new DateBetween();
        if ("DY".equals(timeType)) {
            if(hb == time)
                date = date.minusMonths(1);
            String firstDayOfMonth = date.with(TemporalAdjusters.firstDayOfMonth()).format(defaultFormat);
            String lastDayOfMonth = date.format(defaultFormat);
            dateBetween.setBeginTime(firstDayOfMonth);
            dateBetween.setEndTime(lastDayOfMonth);
        } else if ("SY".equals(timeType)) {
            if(hb == time)
                date = date.minusMonths(1);
            date = date.minusMonths(1);
            String firstDayOfMonth = date.with(TemporalAdjusters.firstDayOfMonth()).format(defaultFormat);
            String lastDayOfMonth = date.format(defaultFormat);
            dateBetween.setBeginTime(firstDayOfMonth);
            dateBetween.setEndTime(lastDayOfMonth);
        } else if ("BJD".equals(timeType)) {
            if(hb == time)
                date = date.minusMonths(3);
            Integer between = betweenFirstDayOfQuarterly(date);//当前月与本季度首月的差值
            String firstDayOfQuarterly = date.minusMonths(between).with(TemporalAdjusters.firstDayOfMonth()).format(defaultFormat);//本季度第一天
            String lastDayOfQuarterly = date.format(defaultFormat);   //本季度最后一天
            dateBetween.setBeginTime(firstDayOfQuarterly);
            dateBetween.setEndTime(lastDayOfQuarterly);
        } else if ("SJD".equals(timeType)) {
            if(hb == time)
                date = date.minusMonths(3);
            date = date.minusMonths(3);
            Integer between = betweenFirstDayOfQuarterly(date);//当前月与本季度首月的差值
            String firstDayOfQuarterly = date.minusMonths(between).with(TemporalAdjusters.firstDayOfMonth()).format(defaultFormat);//本季度第一天
            String lastDayOfQuarterly = date.format(defaultFormat);   //本季度最后一天
            dateBetween.setBeginTime(firstDayOfQuarterly);
            dateBetween.setEndTime(lastDayOfQuarterly);

        } else if ("BN".equals(timeType)) {
            if(hb == time)
                date = date.minusYears(1);
            String firstDayOfYear = date.with(TemporalAdjusters.firstDayOfYear()).format(defaultFormat);
            String lastDayOfYear = date.format(defaultFormat);
            dateBetween.setBeginTime(firstDayOfYear);
            dateBetween.setEndTime(lastDayOfYear);
        } else { //SN
            if(tb == time)
                date = date.plusYears(1);
            date = date.minusYears(1);
            String firstDayOfYear = date.with(TemporalAdjusters.firstDayOfYear()).format(defaultFormat);
            String lastDayOfYear = date.with(TemporalAdjusters.lastDayOfYear()).format(defaultFormat);
            dateBetween.setBeginTime(firstDayOfYear);
            dateBetween.setEndTime(lastDayOfYear);
        }
        return dateBetween;
    }

    /**
     * 获取季度
     *
     * @param date 指定时间
     * @return 当前季度
     * <p>如第1 、第2 、第3 、第4季度
     */
    private static Integer getQuarterly(LocalDate date) {
        int month = date.getMonth().getValue();
        int jd = (month / 3); //获取季度
        if (month % 3 > 0) jd++;
        return jd;
    }

    /**
     * 当前时间与本季度首月的差值
     */
    private static Integer betweenFirstDayOfQuarterly(LocalDate date) {
        Integer quarterly = getQuarterly(date);
        return date.getMonth().getValue() - ((quarterly - 1) * 3) - 1;
    }

}
