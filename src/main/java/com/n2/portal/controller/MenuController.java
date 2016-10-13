package com.n2.portal.controller;

import com.n2.portal.dao.MenuDao;
import com.n2.portal.model.menu.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by dhnhan on 13/10/2016.
 */
@RestController("/menu")
public class MenuController {

    @Autowired
    MenuDao menuDao;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Menu> getMenus(){
        return null;
    }
}
