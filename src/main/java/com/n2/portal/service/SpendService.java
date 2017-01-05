package com.n2.portal.service;

import com.n2.portal.model.expense.SpendCategory;

import java.util.Date;
import java.util.List;

/**
 * Created by buibichngoc on 1/2/2017.
 */
public interface SpendService {
    /**
     * @param date
     * @return
     */
    List<SpendCategory> getAllSpend(Date date);
}
