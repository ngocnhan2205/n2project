package com.n2.portal.model.expense;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by buibichngoc on 1/5/2017.
 */
@MappedSuperclass
public class ExpenseAbstract {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public ExpenseAbstract() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
