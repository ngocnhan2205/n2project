package com.n2.portal.service.impl;

import com.n2.portal.dao.ExpenseDateDao;
import com.n2.portal.dao.SpendDao;
import com.n2.portal.model.expense.ExpenseDate;
import com.n2.portal.model.expense.Spend;
import com.n2.portal.service.SpendService;
import com.n2.portal.utils.N2Security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by buibichngoc on 1/2/2017.
 */
@Service
@Transactional
public class SpendServiceImpl implements SpendService {

    @Autowired
    private SpendDao spendDao;

    @Autowired
    private ExpenseDateDao expenseDateDao;

    public void saveSpend(String name, Date date) {
        String userId = N2Security.getUser();
        ExpenseDate expenseDate = expenseDateDao.getExpenseDateByDate(date, userId);
        if (expenseDate == null) {
            ExpenseDate e = new ExpenseDate();
            e.setDate(date);
            e.setUserId(userId);
            expenseDate = expenseDateDao.saveOrUpdate(e);
        }
        Spend spend = new Spend();
        spend.setName(name);
        spend.setExpense(true);
        spend.setDate(expenseDate);
        spendDao.saveOrUpdate(spend);
    }
}
