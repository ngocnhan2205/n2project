package com.n2.portal.core;

import com.n2.portal.model.expense.SpendCategory;

import java.util.Comparator;

/**
 * Created by buibichngoc on 1/5/2017.
 */
public class CompareSpendCategory implements Comparator<SpendCategory> {


    public int compare(SpendCategory o1, SpendCategory o2) {
        return o1.getId() > o2.getId() ? -1 : o1.equals(o2) ? 0 : 1;
    }
}
