package com.n2.portal.dao;

import com.n2.portal.model.menu.Menu;

import java.util.List;

/**
 * Created by dhnhan on 13/10/2016.
 */
public interface MenuDao extends IGenericDao<Menu, Long> {
    public List<Menu> getMenuWithPermissionAdmin();
}
