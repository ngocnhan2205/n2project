package com.n2.portal.service.impl;

import com.n2.portal.dao.ExpenseDateDao;
import com.n2.portal.dao.SpendDao;
import com.n2.portal.dto.SpendDTO;
import com.n2.portal.model.expense.ExpenseDate;
import com.n2.portal.model.expense.Spend;
import com.n2.portal.model.expense.SpendCategory;
import com.n2.portal.service.SpendService;
import com.n2.portal.utils.N2Security;
import com.n2.portal.utils.N2Util;
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

    public List<SpendCategory> getAllSpend(Date date) {
        String userId = N2Security.getUser();
        ExpenseDate expenseDate = expenseDateDao.getExpenseDateByDate(date, userId);
        List<SpendCategory> result = new ArrayList<SpendCategory>();
        if (expenseDate != null && expenseDate.getSpendCategories() != null)
            result.addAll(expenseDate.getSpendCategories());
        return result;
    }


    private List<SpendDTO> preSpend(List<Spend> spends) {
        List<SpendDTO> dtos = new ArrayList<SpendDTO>();
        SpendDTO dto = null;
        for (Spend spend : spends) {
            if (spend.getParentId() == null) {
                dto = new SpendDTO();
                dto.setSpend(spend);
                dto.setSubSpend(N2Util.getById(spends, spend.getId()));
                dtos.add(dto);
            }
        }
        return dtos;
    }
}
