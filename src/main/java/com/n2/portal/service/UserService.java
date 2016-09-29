package com.n2.portal.service;

import com.n2.portal.model.User;

/**
 * Created by dhnhan on 9/27/2016.
 */
public interface UserService {

    User findById(Long id);

    User findBySso(String sso);
}
