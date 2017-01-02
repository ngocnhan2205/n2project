package com.n2.portal.service;

import java.util.Date;

/**
 * Created by buibichngoc on 1/2/2017.
 */
public interface SpendService {

    /**
     * save spend with expend
     *
     * @param name
     * @param date
     */
    public void saveSpend(String name, Date date);
}
