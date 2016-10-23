package com.n2.portal.model.expense;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by dhnhan on 17/10/2016.
 */
@Entity
@Table(name = "EXPENSE")
public class Expense extends AbstractExpense {
    @Column(name = "TOTAL")
    private Double total;
    @Column(name = "userId")
    private String userId;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "expense")
    @JsonManagedReference
    @Fetch(FetchMode.SELECT)
    private List<Spend> spends;

    public Expense() {
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<Spend> getSpends() {
        return spends;
    }

    public void setSpends(List<Spend> spends) {
        this.spends = spends;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
