package com.oa.main.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * java8 时间类
 * @author rogers
 */
public class DateUtil {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd mm:HH:ss");

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static String dateToString(Object date, boolean withTime) {
        if (date == null) {
            return "";
        }
        if (date instanceof LocalDateTime) {
            if (withTime) {
                return ((LocalDateTime) date).format(DATE_TIME_FORMATTER);
            }
            return ((LocalDateTime) date).format(DATE_FORMATTER);
        }
        if (date instanceof Date) {
            if (withTime) {
                return LocalDateTime.ofInstant(((Date) date).toInstant(), ZoneId.systemDefault()).format(DATE_TIME_FORMATTER);
            }
            return LocalDateTime.ofInstant(((Date) date).toInstant(), ZoneId.systemDefault()).format(DATE_FORMATTER);
        }
        return date.toString();
    }


    /**
     * 字符转转时间
     *
     * @author rogers
     * @date  2021/10/24 13:17
     */
    public static LocalDateTime stringToDatTime(String s) {
        if (s == null) {
            return null;
        }
        return LocalDateTime.parse(s, DATE_TIME_FORMATTER);
    }
}
