package com.n2.portal.model.expense;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by buibichngoc on 1/1/2017.
 */
@Entity
@Table(name = "EXPENSEDATE")
public class ExpenseDate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "DATE")
    private Date date;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "date")
    @JsonManagedReference
    @Fetch(FetchMode.SELECT)
    private List<Spend> spends;

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

    public List<Spend> getSpends() {
        return spends;
    }

    public void setSpends(List<Spend> spends) {
        this.spends = spends;
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
