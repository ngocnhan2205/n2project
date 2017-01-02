package com.n2.portal.dto;


/**
 * Created by buibichngoc on 1/2/2017.
 */
public class ExpenseDateDTO {
    private int date;
    private Double value;
    private String fullDate;
    private String day;
    private boolean active;

    public ExpenseDateDTO() {
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getFullDate() {
        return fullDate;
    }

    public void setFullDate(String fullDate) {
        this.fullDate = fullDate;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
