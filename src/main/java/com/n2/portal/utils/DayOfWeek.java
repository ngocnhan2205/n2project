package com.n2.portal.utils;

/**
 * Created by buibichngoc on 1/2/2017.
 */
public enum DayOfWeek {
    //    var weekday = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];
    SUNDAY(0), MONDAY(1), TUESDAY(2), WEDNESDAY(3), THURSDAY(4), FRIDAY(5), SATURDAY(6);
    public final int day;

    DayOfWeek(int day) {
        this.day = day;
    }
}
