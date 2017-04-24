package com.kurtomerfaruk.admin.controllers;

import com.kurtomerfaruk.admin.models.City;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author Omer Faruk KURT e-mail:kurtomerfaruk@gmail.com
 */
@ManagedBean
@ViewScoped
public class CityController extends AbstractController<City> implements java.io.Serializable {

    private static final long serialVersionUID = -634671916894922681L;

    @ManagedProperty("#{countryController}")
    private CountryController countryIdController;
    @ManagedProperty("#{menuController}")
    private MenuController menuController;

    /**
     *
     */
    public CityController() {
        // Inform the Abstract parent controller of the concrete City Entity
        super(City.class);
        columnNames();
        columnList();
    }

    /**
     *
     * @return
     */
    public CountryController getCountryIdController() {
        return countryIdController;
    }

    /**
     *
     * @param countryIdController
     */
    public void setCountryIdController(CountryController countryIdController) {
        this.countryIdController = countryIdController;
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
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    @Override
    public void resetParents() {
        countryIdController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Country controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCountryId(ActionEvent event) {
        if (this.getSelected() != null && countryIdController.getSelected() == null) {
            countryIdController.setSelected(this.getSelected().getCountryId());
        }
    }

    /**
     * Sets the "items" attribute with a collection of Address entities that are
     * retrieved from City?cap_first and returns the navigation outcome.
     *
     */
    public void navigateAddressList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Address_items", this.getSelected().getAddressList());
        }
        menuController.setPageLink("/address/index");
        menuController.setPageName("Address List");
    }

}
