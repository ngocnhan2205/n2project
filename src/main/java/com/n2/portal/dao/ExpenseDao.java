package com.n2.portal.dao;

import com.n2.portal.model.expense.Expense;

import java.util.List;

/**
 * Created by dhnhan on 20/10/2016.
 */
public interface ExpenseDao extends IGenericDao<Expense, Long> {

    public List<Expense> getExpenseByUserId(String userId);

    public Expense getExpense(Long id, String userId);
}
