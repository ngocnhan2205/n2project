package com.n2.portal.model.expense;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

/**
 * Created by buibichngoc on 1/1/2017.
 */
@Entity
@Table(name = "SPEND")
public class Spend extends ExpenseAbstract {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "VALUE")
    private Double value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "spend_category")
    @JsonBackReference
    private SpendCategory spendCategory;

    @Column(name = "FILEATTACH")
    private String fileAttach;


    public Spend() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public SpendCategory getSpendCategory() {
        return spendCategory;
    }

    public void setSpendCategory(SpendCategory spendCategory) {
        this.spendCategory = spendCategory;
    }

    public String getFileAttach() {
        return fileAttach;
    }

    public void setFileAttach(String fileAttach) {
        this.fileAttach = fileAttach;
    }

}
