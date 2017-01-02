package com.n2.portal.dao;

import com.n2.portal.model.expense.ExpenseDate;

import java.util.Date;
import java.util.List;

/**
 * Created by buibichngoc on 1/2/2017.
 */
public interface ExpenseDateDao extends IGenericDao<ExpenseDate, Long> {

    /**
     * get all date by user and end date between start date
     *
     * @param userId
     * @param endDate
     * @param startDate
     * @return
     */
    List<ExpenseDate> getAllDate(String userId, Date endDate, Date startDate);

    /**
     * get date by date and user id
     *
     * @param date
     * @param userId
     * @return
     */
    ExpenseDate getExpenseDateByDate(Date date, String userId);
}
