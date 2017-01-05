package com.n2.portal.model.expense;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by buibichngoc on 1/5/2017.
 */
@MappedSuperclass
public class ExpenseAbstract implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "PARENTID")
    private Long parentId;

    public ExpenseAbstract() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
