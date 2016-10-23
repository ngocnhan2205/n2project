package com.n2.portal.dao;

import com.n2.portal.model.expense.Spend;

import java.util.Date;
import java.util.List;

/**
 * Created by dhnhan on 20/10/2016.
 */
public interface SpendDao extends IGenericDao<Spend, Long> {

    public List<Spend> getSpendWithExpense(Date sDate, Date eDate, Long expenseId);

    public void deleteSpend(Long idExpense);
}
