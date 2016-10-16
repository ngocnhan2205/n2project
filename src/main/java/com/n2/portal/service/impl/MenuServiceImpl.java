package com.n2.portal.service.impl;

import com.n2.portal.dao.MenuDao;
import com.n2.portal.model.menu.Menu;
import com.n2.portal.service.MenuService;
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
        return menuDao.getAll();
    }
}
