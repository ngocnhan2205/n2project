package com.n2.portal.service;

import com.n2.portal.dto.ExpenseDTO;
import com.n2.portal.model.expense.Expense;

import java.util.Date;
import java.util.List;

/**
 * Created by dhnhan on 20/10/2016.
 */
public interface ExpenseService {
    public Expense saveExpense(ExpenseDTO dto);

    public List<Expense> getExpenses(Date date,String gran, Long id);
}
