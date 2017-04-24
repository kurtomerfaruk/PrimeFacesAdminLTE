package com.kurtomerfaruk.admin.controllers;

import com.kurtomerfaruk.admin.models.Address;
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
public class AddressController extends AbstractController<Address> implements java.io.Serializable {

    private static final long serialVersionUID = -4847109372134790357L;

    @ManagedProperty("#{cityController}")
    private CityController cityController;

    @ManagedProperty("#{menuController}")
    private MenuController menuController;

    /**
     *
     */
    public AddressController() {
        super(Address.class);
        columnNames();
        columnList();
    }

    /**
     *
     * @return
     */
    public CityController getCityController() {
        return cityController;
    }

    /**
     *
     * @param cityController
     */
    public void setCityController(CityController cityController) {
        this.cityController = cityController;
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
        cityController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Store entities that are
     * retrieved from Address?cap_first and returns the navigation outcome.
     *
     */
    public void navigateStoreList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Store_items", this.getSelected().getStoreList());
        }
        menuController.setPage("/store/index", "Store List");
    }

    /**
     * Sets the "items" attribute with a collection of Customer entities that
     * are retrieved from Address?cap_first and returns the navigation outcome.
     *
     */
    public void navigateCustomerList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Customer_items", this.getSelected().getCustomerList());
        }
        menuController.setPage("/customer/index", "Customer List");
    }

    /**
     * Sets the "items" attribute with a collection of Staff entities that are
     * retrieved from Address?cap_first and returns the navigation outcome.
     *
     */
    public void navigateStaffList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Staff_items", this.getSelected().getStaffList());
        }
        menuController.setPage("/staff/index", "Staff List");
    }

    /**
     * Sets the "selected" attribute of the City controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCityId(ActionEvent event) {
        if (this.getSelected() != null && cityController.getSelected() == null) {
            cityController.setSelected(this.getSelected().getCityId());
        }
    }
}
