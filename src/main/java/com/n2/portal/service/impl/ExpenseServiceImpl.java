package com.n2.portal.service.impl;

import com.n2.portal.dao.ExpenseDao;
import com.n2.portal.dao.SpendDao;
import com.n2.portal.dto.ExpenseDTO;
import com.n2.portal.model.expense.Expense;
import com.n2.portal.model.expense.Spend;
import com.n2.portal.service.ExpenseService;
import com.n2.portal.utils.N2Date;
import com.n2.portal.utils.N2Security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


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
        Expense e = dto.getExpense();
        e.setUserId(N2Security.getUser());
        e.setTotal((double) 0F);
        Expense expense = expenseDao.saveOrUpdate(dto.getExpense());
        return expense;
    }

    public List<Expense> getExpenses(Date date, String gran) {
        List<Expense> expenses = expenseDao.getExpenseByUserId(N2Security.getUser());
        Date startDate = N2Date.getDate(gran, date, N2Date.START);
        Date endDate = N2Date.getDate(gran, date, N2Date.END);
        List<Spend> spends;
        for (Expense e : expenses) {
            spends = spendDao.getSpendWithExpense(startDate, endDate, e.getId());
            if (spends != null) {
                e.setTotal(caculatorPrice(spends));
            }
            e.setSpends(spends);
        }
        return expenses;
    }

    private double caculatorPrice(List<Spend> spends) {
        double rs = 0F;
        for (Spend s : spends) {
            rs += s.getPrice();
        }
        return rs;
    }
}
