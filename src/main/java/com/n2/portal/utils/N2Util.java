package com.n2.portal.utils;


import com.n2.portal.model.expense.ExpenseAbstract;

import java.util.List;

/**
 * Created by dhnhan on 23/10/2016.
 */
public final class N2Util {
    private N2Util() {
    }

    public static <T extends ExpenseAbstract> Long getById(List<T> list, String id) {
        for (T t : list) {
            if (id.equals(t.getId())) {
                return t.getId();
            }
        }
        return null;
    }

}
