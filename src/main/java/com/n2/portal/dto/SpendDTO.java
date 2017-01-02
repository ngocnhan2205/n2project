package com.n2.portal.dto;

import com.n2.portal.model.expense.Spend;

import java.util.List;

/**
 * Created by buibichngoc on 1/2/2017.
 */
public class SpendDTO {
    private Spend spend;
    private List<Spend> subSpend;

    public SpendDTO() {
    }

    public Spend getSpend() {
        return spend;
    }

    public void setSpend(Spend spend) {
        this.spend = spend;
    }

    public List<Spend> getSubSpend() {
        return subSpend;
    }

    public void setSubSpend(List<Spend> subSpend) {
        this.subSpend = subSpend;
    }
}
