package com.n2.portal.utils;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by dhnhan on 20/10/2016.
 */
public class N2Date {
    public static final String DAY = "day";
    public static final String MONTH = "month";
    public static final int START = 1;
    public static final int END = 0;



    public static Date getDate(String gran, Date date, int typeDate){
        Date rs = formatDate(date);
        Calendar calendar = calendarDate(rs);
        if (gran.equalsIgnoreCase(MONTH)){
            if (typeDate == START){
                calendar.set(Calendar.DAY_OF_MONTH, 1);
            } else {
                calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
            }
        }
        return calendar.getTime();
    }

    public static Calendar calendarDate(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    public static Date formatDate(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }
}
