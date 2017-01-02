package com.n2.portal.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by dhnhan on 20/10/2016.
 */
public final class N2Date {
    private N2Date() {
    }

    public static final String FORMAT_DATE = "dd/MM/yyyy";

    /**
     * create calendar with date
     *
     * @param date
     * @return
     */
    public static Calendar calendarDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    /**
     * get instance date with set MINUTE HOUR MILLISECOND SECOND to value 0
     *
     * @param date
     * @return
     */
    public static Date getInstance(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * parse date to string with format dd/MM/yyyy
     *
     * @param date
     * @return
     */
    public static Date parseDate(String date) {
        DateFormat df = new SimpleDateFormat(FORMAT_DATE);
        Date rs = null;
        try {
            rs = df.parse(date);
            return rs;
        } catch (ParseException e) {
            e.printStackTrace();
            return rs;
        }
    }

    /**
     * get first date of month
     *
     * @param month
     * @param year
     * @return
     */
    public static Date getFistDateOfMonth(int month, int year) {
        Calendar calendar = calendarDate(new Date());
        calendar.set(year, month, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    /**
     * get last date of mont
     *
     * @param month
     * @param year
     * @return
     */
    public static Date getLastDateOfMonth(int month, int year) {
        Calendar calendar = calendarDate(new Date());
        calendar.set(year, month, 1);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return calendar.getTime();
    }

    /**
     * @param date
     * @return
     */
    public static String getDayOfWeek(Date date) {
        Calendar calendar = calendarDate(date);
        String day = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.US);
        return day;
    }

    /**
     * convert date to string with format {@value FORMAT_DATE}
     *
     * @param date
     * @param format
     * @return
     */
    public static String convertDateToString(Date date, String format) {
        SimpleDateFormat f = new SimpleDateFormat(format);
        return f.format(date);
    }

    /**
     * convert date to string format {@value FORMAT_DATE}
     *
     * @param date
     * @return
     */
    public static String convertDateToStringDefault(Date date) {
        return convertDateToString(date, FORMAT_DATE);
    }

    /**
     * @param date
     * @return
     */
    public static int getDate(Date date) {
        Calendar calendar = calendarDate(date);
        return calendar.get(Calendar.DATE);
    }

    /**
     * create a instance date with year, month, date
     *
     * @param year
     * @param month
     * @param date
     * @return
     */
    public static Date newDate(int year, int month, int date) {
        Calendar calendar = calendarDate(new Date());
        calendar.set(year, month, date);
        return calendar.getTime();
    }

    /**
     * compare two date
     *
     * @param d1
     * @param d2
     * @return
     */
    public static boolean compareDate(Date d1, Date d2) {
        Date date1 = getInstance(d1);
        Date date2 = getInstance(d2);
        return date1.compareTo(date2) == 0;
    }


}
