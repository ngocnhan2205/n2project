package com.n2.portal.service.impl;

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
        spend.setExpense(true);
        spend.setDate(expenseDate);
        return spendDao.saveOrUpdate(spend);
    }

    public List<SpendDTO> getAllSpend(Date date) {
        List<Spend> spends = spendDao.getSpendWithExpense(date, N2Security.getUser(), true);
        List<SpendDTO> spendDTOS = new ArrayList<SpendDTO>();
        SpendDTO dto = null;
        for (Spend s : spends) {
            dto = new SpendDTO();
            dto.setSpend(s);
            dto.setSubSpend(new ArrayList<Spend>());
        }
        return spendDTOS;
    }
}
