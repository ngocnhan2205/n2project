package com.n2.portal.service.impl;

import com.n2.portal.dao.SpendDao;
import com.n2.portal.model.expense.Spend;
import com.n2.portal.service.SpendService;
import com.n2.portal.utils.N2Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by dhnhan on 23/10/2016.
 */
@Service
@Transactional
public class SpendServiceImpl implements SpendService {

    @Autowired
    private SpendDao spendDao;

    public Spend saveSpend(Spend spend) {
        spend.setDateSpend(N2Date.formatDate(spend.getDateSpend()));
        return spendDao.saveOrUpdate(spend);
    }
}
