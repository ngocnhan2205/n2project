package com.n2.portal.dao.impl;

import com.n2.portal.dao.GenericDao;
import com.n2.portal.dao.MenuDao;
import com.n2.portal.model.menu.Menu;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dhnhan on 13/10/2016.
 */
@Repository
public class MenuDaoImpl extends GenericDao<Menu,Long> implements MenuDao {

    public List<Menu> getMenuWithPermissionAdmin() {
        Criteria cr = createEntityCriteria();
        cr.add(Restrictions.eq("isAdmin", false));
        cr.addOrder(Order.asc("orderIndex"));
        return cr.list();
    }

    @Override
    public List<Menu> getAll() {
        Criteria cr = createEntityCriteria();
        cr.addOrder(Order.asc("orderIndex"));
        return cr.list();
    }
}
