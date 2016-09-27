package com.n2.portal.controller;

import com.n2.portal.model.User;
import com.n2.portal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dhnhan on 9/27/2016.
 */
@RestController
public class UserRestController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public User demo(){
        return userService.findBySso("admin");
    }
}
