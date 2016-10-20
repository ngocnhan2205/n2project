package com.n2.portal.dao.impl;

import com.n2.portal.dao.ExpenseDao;
import com.n2.portal.dao.GenericDao;
import com.n2.portal.model.expense.Expense;
import org.springframework.stereotype.Repository;

/**
 * Created by dhnhan on 20/10/2016.
 */
@Repository
public class ExpenseDaoImpl extends GenericDao<Expense,Long> implements ExpenseDao {
}
