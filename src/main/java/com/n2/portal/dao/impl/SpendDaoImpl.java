package com.n2.portal.dao.impl;

import com.n2.portal.dao.GenericDao;
import com.n2.portal.dao.SpendDao;
import com.n2.portal.model.expense.Spend;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by dhnhan on 20/10/2016.
 */
@Repository
public class SpendDaoImpl extends GenericDao<Spend,Long> implements SpendDao {
    public List<Spend> getSpendWithExpense(Date sDate,Date eDate, Long expenseId) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions
                .and(Restrictions.and(Restrictions.ge("dateSpend", sDate), Restrictions.le("dateSpend", eDate)),
                    Restrictions.eq("expense.id", expenseId)));
        return null;
    }
}