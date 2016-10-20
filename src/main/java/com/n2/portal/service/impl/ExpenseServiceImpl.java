package com.n2.portal.service.impl;

import com.n2.portal.dao.ExpenseDao;
import com.n2.portal.dao.SpendDao;
import com.n2.portal.dto.ExpenseDTO;
import com.n2.portal.model.expense.Expense;
import com.n2.portal.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by dhnhan on 20/10/2016.
 */
@Service
@Transactional
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseDao expenseDao;

    @Autowired
    private SpendDao spendDao;

    public Expense saveExpense(ExpenseDTO dto) {
        Expense expense = expenseDao.saveOrUpdate(dto.getExpense());
        expense.setTotal((double) 0F);
        return expense;
    }
}
