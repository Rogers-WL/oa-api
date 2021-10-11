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
}
