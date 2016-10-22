package com.n2.portal.controller;

import com.n2.portal.model.User;
import com.n2.portal.service.UserService;
import com.n2.portal.utils.N2Security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dhnhan on 9/27/2016.
 */
@RestController
@RequestMapping("/n2")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/api/user", method = RequestMethod.GET)
    public User getUserCurrent() {
        return userService.findBySso(N2Security.getUser());
    }
}
