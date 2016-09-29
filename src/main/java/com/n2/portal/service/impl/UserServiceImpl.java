package com.n2.portal.service.impl;

import com.n2.portal.dao.UserDao;
import com.n2.portal.model.User;
import com.n2.portal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by dhnhan on 9/27/2016.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public User findById(Long id) {
        return userDao.getById(id);
    }

    public User findBySso(String sso) {
        return userDao.findBySSO(sso);
    }
}
