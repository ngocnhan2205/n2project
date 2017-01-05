package com.n2.portal.service;

import com.n2.portal.dto.SpendDTO;
import com.n2.portal.model.expense.Spend;

import java.util.Date;
import java.util.List;

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
    Spend saveSpendCategory(String name, Date date);

    /**
     * @param date
     * @return
     */
    List<SpendDTO> getAllSpend(Date date);
}
