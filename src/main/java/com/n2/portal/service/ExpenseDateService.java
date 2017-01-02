package com.n2.portal.service;

import com.n2.portal.dto.ExpenseDateDTO;

import java.util.List;

/**
 * Created by buibichngoc on 1/2/2017.
 */
public interface ExpenseDateService {

    /**
     * get all date from first date to last date of month
     *
     * @param month
     * @return
     */
    List<ExpenseDateDTO> getDates(int month, int year);
}
