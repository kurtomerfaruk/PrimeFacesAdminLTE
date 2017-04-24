package com.kurtomerfaruk.admin.controllers;

import com.kurtomerfaruk.admin.models.Customer;
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
public class CustomerController extends AbstractController<Customer> implements java.io.Serializable {

    private static final long serialVersionUID = -7119149667651910482L;

    @ManagedProperty("#{menuController}")
    private MenuController menuController;
    @ManagedProperty("#{addressController}")
    private AddressController addressController;
    @ManagedProperty("#{storeController}")
    private StoreController storeController;

    /**
     *
     */
    public CustomerController() {
        super(Customer.class);
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
     *
     * @return
     */
    public AddressController getAddressController() {
        return addressController;
    }

    /**
     *
     * @param addressController
     */
    public void setAddressController(AddressController addressController) {
        this.addressController = addressController;
    }

    /**
     *
     * @return
     */
    public StoreController getStoreController() {
        return storeController;
    }

    /**
     *
     * @param storeController
     */
    public void setStoreController(StoreController storeController) {
        this.storeController = storeController;
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    @Override
    public void resetParents() {
        storeController.setSelected(null);
        addressController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Payment entities that are
     * retrieved from Customer?cap_first and returns the navigation outcome.
     *
     */
    public void navigatePaymentList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Payment_items", this.getSelected().getPaymentList());
        }
        //menuController.setPage("/payment/index", this.getSelected().getFirstName() + " " + this.getSelected().getLastName());
        menuController.setPageLink("/payment/index");
        menuController.setPageName(this.getSelected().getFirstName() + " " + this.getSelected().getLastName());
    }

    /**
     * Sets the "items" attribute with a collection of Rental entities that are
     * retrieved from Customer?cap_first and returns the navigation outcome.
     *
     */
    public void navigateRentalList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Rental_items", this.getSelected().getRentalList());
        }
        //menuController.setPage("/rental/index", this.getSelected().getFirstName() + " " + this.getSelected().getLastName());
        menuController.setPageLink("/rental/index");
        menuController.setPageName(this.getSelected().getFirstName() + " " + this.getSelected().getLastName());
    }

    /**
     * Sets the "selected" attribute of the Store controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareStoreId(ActionEvent event) {
        if (this.getSelected() != null && storeController.getSelected() == null) {
            storeController.setSelected(this.getSelected().getStoreId());
        }
    }

    /**
     * Sets the "selected" attribute of the Address controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareAddressId(ActionEvent event) {
        if (this.getSelected() != null && addressController.getSelected() == null) {
            addressController.setSelected(this.getSelected().getAddressId());
        }
    }
}
