package com.n2.portal.service.impl;

import com.n2.portal.dao.MenuDao;
import com.n2.portal.model.UserProfileType;
import com.n2.portal.model.menu.Menu;
import com.n2.portal.service.MenuService;
import com.n2.portal.utils.N2Security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dhnhan on 13/10/2016.
 */
@Service
@Transactional
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuDao menuDao;

    public List<Menu> getMenu() {
        boolean role = N2Security.hasRole("ROLE_" + UserProfileType.ADMIN.getUserProfileType());
        if (role)
            return menuDao.getAll();
        else
            return menuDao.getMenuWithPermissionAdmin();
    }
}
