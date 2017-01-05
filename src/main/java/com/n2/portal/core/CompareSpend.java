package com.n2.portal.core;

import com.n2.portal.model.expense.Spend;

import java.util.Comparator;

/**
 * Created by buibichngoc on 1/5/2017.
 */
public class CompareSpend implements Comparator<Spend> {


    public int compare(Spend o1, Spend o2) {
        String s1;
        String s2;
        if (o1.getParentId() != null) {
            s1 = o1.getId().toString() + (char) Integer.parseInt(o1.getParentId().toString());
        } else {
            s1 = o1.getId().toString();
        }
        if (o2.getParentId() != null) {
            s2 = o2.getId().toString() + (char) Integer.parseInt(o2.getParentId().toString());
        } else {
            s2 = o2.getId().toString();
        }
        return s1.compareTo(s2);
    }
}
