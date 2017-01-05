package com.n2.portal.model.expense;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by buibichngoc on 1/5/2017.
 */
@Entity
@Table(name = "SPENDCATEGORY")
public class SpendCategory extends ExpenseAbstract {

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "date_id")
    @JsonBackReference
    private ExpenseDate date;

    @Column(name = "TOTAL")
    private Double total;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "spendCategory")
    @JsonManagedReference
    private Set<Spend> spends = new HashSet<Spend>(0);

    public SpendCategory() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ExpenseDate getDate() {
        return date;
    }

    public void setDate(ExpenseDate date) {
        this.date = date;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Set<Spend> getSpends() {
        return spends;
    }

    public void setSpends(Set<Spend> spends) {
        this.spends = spends;
    }
}
