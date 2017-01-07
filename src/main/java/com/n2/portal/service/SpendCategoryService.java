package com.n2.portal.service;

import com.n2.portal.model.expense.SpendCategory;

import java.util.Date;

/**
 * Created by buibichngoc on 1/5/2017.
 */
public interface SpendCategoryService {

    /**
     * @param name
     * @param date
     * @return
     */
    SpendCategory save(String name, Date date);

    /**
     * @param id
     * @param name
     * @return
     */
    SpendCategory update(Long id, String name);
}
