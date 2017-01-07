package com.n2.portal.service.impl;

import com.n2.portal.dao.ExpenseDateDao;
import com.n2.portal.dao.SpendCategoryDao;
import com.n2.portal.model.expense.ExpenseDate;
import com.n2.portal.model.expense.SpendCategory;
import com.n2.portal.service.SpendCategoryService;
import com.n2.portal.utils.N2Security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by buibichngoc on 1/5/2017.
 */
@Service
@Transactional
public class SpendCategoryServiceImpl implements SpendCategoryService {

    @Autowired
    private SpendCategoryDao spendCategoryDao;

    @Autowired
    private ExpenseDateDao expenseDateDao;

    public SpendCategory save(String name, Date date) {
        String userId = N2Security.getUser();
        ExpenseDate expenseDate = expenseDateDao.getExpenseDateByDate(date, userId);
        if (expenseDate == null) {
            ExpenseDate d = new ExpenseDate();
            d.setDate(date);
            d.setUserId(userId);
            expenseDate = expenseDateDao.saveOrUpdate(d);
        }
        SpendCategory spendCategory = new SpendCategory();
        spendCategory.setDate(expenseDate);
        spendCategory.setName(name);
        return spendCategoryDao.saveOrUpdate(spendCategory);
    }

    public SpendCategory update(Long id, String name) {
        SpendCategory spendCategory = spendCategoryDao.getById(id);
        spendCategory.setName(name);
        return spendCategoryDao.saveOrUpdate(spendCategory);
    }
}
