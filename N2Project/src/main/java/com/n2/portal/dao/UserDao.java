package com.n2.portal.dao;

import com.n2.portal.model.User;

/**
 * Created by dhnhan on 9/27/2016.
 */
public interface UserDao extends IGenericDao<User, Long> {
    User findBySSO(String sso);
}
