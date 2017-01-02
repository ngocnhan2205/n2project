package com.n2.portal.dao;

import com.n2.portal.model.expense.Spend;

import java.util.Date;
import java.util.List;

/**
 * Created by buibichngoc on 1/2/2017.
 */
public interface SpendDao extends IGenericDao<Spend, Long> {

    /**
     * @param date
     * @param userId
     * @param expense
     * @return
     */
    List<Spend> getSpendWithExpense(Date date, String userId, boolean expense);
}
