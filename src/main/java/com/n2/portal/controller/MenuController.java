package com.n2.portal.controller;

import com.n2.portal.model.menu.Menu;
import com.n2.portal.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/n2")
public class MenuController {

    @Autowired
    MenuService menuService;

    @RequestMapping(value="/api/menu", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Menu> getMenus(){
        return menuService.getMenu();
    }
}
