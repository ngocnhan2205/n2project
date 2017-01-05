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
}
