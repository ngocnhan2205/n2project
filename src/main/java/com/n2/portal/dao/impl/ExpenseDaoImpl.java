package com.n2.portal.dao.impl;

import com.n2.portal.dao.ExpenseDao;
import com.n2.portal.dao.GenericDao;
import com.n2.portal.model.expense.Expense;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dhnhan on 20/10/2016.
 */
@Repository
public class ExpenseDaoImpl extends GenericDao<Expense,Long> implements ExpenseDao {

    public List<Expense> getExpenseByUserId(String userId) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("userId", userId));
        return criteria.list();
    }
}
