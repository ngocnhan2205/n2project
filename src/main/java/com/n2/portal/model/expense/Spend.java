package com.n2.portal.model.expense;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by dhnhan on 17/10/2016.
 */
@Entity
@Table(name = "SPEND")
public class Spend extends AbstractExpense {

    @Column(name = "PRICE")
    private Double price;

    @Column(name = "DATE_SPEND")
    private Date dateSpend;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EXPENSE_ID", nullable = false)
    @JsonBackReference
    private Expense expense;

    public Spend() {
    }

    public Date getDateSpend() {
        return dateSpend;
    }

    public void setDateSpend(Date dateSpend) {
        this.dateSpend = dateSpend;
    }

    public Expense getExpense() {
        return expense;
    }

    public void setExpense(Expense expense) {
        this.expense = expense;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
