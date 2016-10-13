package com.n2.portal.dao.impl;

import com.n2.portal.dao.GenericDao;
import com.n2.portal.dao.MenuDao;
import com.n2.portal.model.menu.Menu;
import org.springframework.stereotype.Repository;

/**
 * Created by dhnhan on 13/10/2016.
 */
@Repository
public class MenuDaoImpl extends GenericDao<Menu,Long> implements MenuDao{
}
