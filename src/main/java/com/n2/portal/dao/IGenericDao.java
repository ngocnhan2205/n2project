package com.n2.portal.dao;


import java.util.List;

/**
 * Created by nhandh on 9/18/2016.
 */
public interface IGenericDao<T, PK> {
    public T getById(PK id);

    public T persist(T entity);

    public T delete(T object);

    public List<T> getAll();

    public T saveOrUpdate(T o);
}
