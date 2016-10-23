package com.n2.portal.model.menu;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

/**
 * Created by dhnhan on 12/10/2016.
 */
@Entity
@Table(name = "MENU")
public class Menu extends AbstractMenu {

    @Column(name = "ISADMIN")
    private boolean isAdmin;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "menu")
    @JsonManagedReference
    private List<SubMenu> subMenu;

    public Menu() {
    }

    public List<SubMenu> getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(List<SubMenu> subMenu) {
        this.subMenu = subMenu;
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
