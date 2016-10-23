package com.n2.portal.model.menu;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

/**
 * Created by dhnhan on 12/10/2016.
 */
@Entity
@Table(name = "SUBMENU")
public class SubMenu extends AbstractMenu {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MENU_ID", nullable = false)
    @JsonBackReference
    private Menu menu;

    public SubMenu() {
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
