package com.n2.portal.utils;


import com.n2.portal.model.expense.ExpenseAbstract;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dhnhan on 23/10/2016.
 */
public final class N2Util {
    private N2Util() {
    }

    public static <T extends ExpenseAbstract> List<T> getById(List<T> list, String parentId) {
        List<T> listObject = new ArrayList<T>();
        for (T t : list) {
            if (parentId.equals(t.getParentId())) {
                listObject.add(t);
            }
        }
        return listObject;
    }

}
