package com.n2.portal.model.expense;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by buibichngoc on 1/1/2017.
 */
@Entity
@Table(name = "EXPENSEDATE")
public class ExpenseDate implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "DATE")
    private Date date;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "date")
    @JsonManagedReference
    private Set<SpendCategory> spendCategories = new HashSet<SpendCategory>(0);

    @Column(name = "TOTAL")
    private Double total;

    @Column(name = "USERID")
    private String userId;

    public ExpenseDate() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Set<SpendCategory> getSpendCategories() {
        return spendCategories;
    }

    public void setSpendCategories(Set<SpendCategory> spendCategories) {
        this.spendCategories = spendCategories;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}
