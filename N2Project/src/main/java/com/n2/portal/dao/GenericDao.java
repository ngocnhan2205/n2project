package com.n2.portal.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by nhandh on 9/18/2016.
 */
public abstract class GenericDao<T, PK extends Serializable> implements IGenericDao<T, PK> {

    @Autowired
    private SessionFactory sessionFactory;

    protected Class<? extends T> type;

    public GenericDao() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public T getById(PK id) {
        return (T) getSession().get(this.type, id);
    }

    public T persist(T entity) {
        getSession().persist(entity);
        return entity;
    }


    public T delete(T object) {
        getSession().delete(object);
        return object;
    }

    public List<T> getAll() {
        return createEntityCriteria().list();
    }

    protected Criteria createEntityCriteria() {
        return getSession().createCriteria(this.type);
    }

    public T saveOrUpdate(T o) {
        getSession().saveOrUpdate(o);
        return o;
    }
}
