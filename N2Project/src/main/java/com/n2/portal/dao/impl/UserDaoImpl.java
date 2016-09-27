package com.n2.portal.dao.impl;

import com.n2.portal.dao.GenericDao;
import com.n2.portal.dao.UserDao;
import com.n2.portal.model.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by dhnhan on 9/27/2016.
 */
@Repository
@Transactional
public class UserDaoImpl extends GenericDao<User, Long> implements UserDao {

    public User findBySSO(String sso) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("ssoId", sso));
        return (User) crit.uniqueResult();
    }
}
