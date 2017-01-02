package com.n2.portal.dao.impl;

import com.n2.portal.dao.ExpenseDateDao;
import com.n2.portal.dao.GenericDao;
import com.n2.portal.model.expense.ExpenseDate;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


/**
 * Created by buibichngoc on 1/2/2017.
 */
@Repository
public class ExpenseDaoImpl extends GenericDao<ExpenseDate, Long> implements ExpenseDateDao {

    public List<ExpenseDate> getAllDate(String userId, Date endDate, Date startDate) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.and(
                Restrictions.and(Restrictions.ge("date", endDate),
                        Restrictions.le("date", startDate)),
                Restrictions.eq("userId", userId)));
        return criteria.list();
    }
}
