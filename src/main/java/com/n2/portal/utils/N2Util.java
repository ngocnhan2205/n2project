package com.n2.portal.utils;

import com.n2.portal.model.expense.Spend;

import java.util.List;

/**
 * Created by dhnhan on 23/10/2016.
 */
public class N2Util {
    public static double caculatorPrice(List<Spend> spends) {
        double rs = 0F;
        for (Spend s : spends) {
            rs += s.getPrice();
        }
        return rs;
    }
}
