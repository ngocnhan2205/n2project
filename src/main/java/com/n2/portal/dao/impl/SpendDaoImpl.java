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
 * Created by buibichngoc on 1/2/2017.
 */
@Repository
public class SpendDaoImpl extends GenericDao<Spend, Long> implements SpendDao {

    public List<Spend> getSpendWithExpense(Date date, String userId, boolean expense) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.and(Restrictions.eq("date.date", date),
                Restrictions.eq("date.userId", userId),
                Restrictions.eq("expense", expense)));
        return criteria.list();
    }
}
