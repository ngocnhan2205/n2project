package com.n2.portal.dto;

import com.n2.portal.model.expense.Expense;

import java.util.Date;

/**
 * Created by dhnhan on 20/10/2016.
 */
public class ExpenseDTO {
    private Expense expense;
    private String gran;
    private Date date;

    public ExpenseDTO() {
    }

    public Expense getExpense() {
        return expense;
    }

    public void setExpense(Expense expense) {
        this.expense = expense;
    }

    public String getGran() {
        return gran;
    }

    public void setGran(String gran) {
        this.gran = gran;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
