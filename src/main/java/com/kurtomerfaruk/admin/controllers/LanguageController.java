package com.kurtomerfaruk.admin.controllers;

import com.kurtomerfaruk.admin.models.Language;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Omer Faruk KURT e-mail:kurtomerfaruk@gmail.com
 */
@ManagedBean
@ViewScoped
public class LanguageController extends AbstractController<Language> implements java.io.Serializable {

    private static final long serialVersionUID = -2620288857801059950L;

    @ManagedProperty("#{menuController}")
    private MenuController menuController;

    /**
     *
     */
    public LanguageController() {
        super(Language.class);
        columnNames();
        columnList();
    }

    /**
     *
     * @return
     */
    public MenuController getMenuController() {
        return menuController;
    }

    /**
     *
     * @param menuController
     */
    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
    }

    /**
     * Sets the "items" attribute with a collection of Film entities that are
     * retrieved from Language?cap_first and returns the navigation outcome.
     *
     */
    public void navigateFilmList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Film_items", this.getSelected().getFilmList());
        }
        menuController.setPageLink("/film/index");
        menuController.setPageName(this.getSelected().getName());
    }

    /**
     * Sets the "items" attribute with a collection of Film entities that are
     * retrieved from Language?cap_first and returns the navigation outcome.
     *
     */
    public void navigateFilmList1() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Film_items", this.getSelected().getFilmList1());
        }
        menuController.setPageLink("/film/index");
        menuController.setPageName(this.getSelected().getName());
    }

}
