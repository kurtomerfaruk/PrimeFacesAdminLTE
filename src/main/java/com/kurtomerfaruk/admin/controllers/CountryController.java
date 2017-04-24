package com.kurtomerfaruk.admin.controllers;

import com.kurtomerfaruk.admin.models.Country;
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
public class CountryController extends AbstractController<Country> implements java.io.Serializable {

    private static final long serialVersionUID = -443630287978001712L;

    @ManagedProperty("#{menuController}")
    private MenuController menuController;

    /**
     *
     */
    public CountryController() {
        // Inform the Abstract parent controller of the concrete Country Entity
        super(Country.class);
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
     * Sets the "items" attribute with a collection of City entities that are
     * retrieved from Country?cap_first and returns the navigation outcome.
     *
     */
    public void navigateCityList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("City_items", this.getSelected().getCityList());
        }
        menuController.setPageName(this.getSelected().getCountry());
        menuController.setPageLink("/city/index");
    }

}
