package com.n2.portal.service.impl;

import com.n2.portal.core.CompareSpend;
import com.n2.portal.dao.ExpenseDateDao;
import com.n2.portal.dao.SpendDao;
import com.n2.portal.dto.SpendDTO;
import com.n2.portal.model.expense.ExpenseDate;
import com.n2.portal.model.expense.Spend;
import com.n2.portal.service.SpendService;
import com.n2.portal.utils.N2Security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

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

    public Spend saveSpend(String name, Date date) {
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
        spend.setDate(expenseDate);
        spend.setParentId(null);
        return spendDao.saveOrUpdate(spend);
    }

    public List<SpendDTO> getAllSpend(Date date) {
        String userId = N2Security.getUser();
        ExpenseDate expenseDate = expenseDateDao.getExpenseDateByDate(date, userId);
        List<Spend> spends = expenseDate.getSpends();
        //Collections.sort(spends, new CompareSpend());
        return null;
    }


    private List<SpendDTO> preSpend(List<Spend> spends) {
        List<SpendDTO> dtos = new ArrayList<SpendDTO>();
        List<Spend> sp = null;
        SpendDTO dto = null;
        for (Spend spend : spends) {
            if (spend.getParentId() == null) {

            }
        }
        return dtos;
    }
}
