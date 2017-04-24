package com.kurtomerfaruk.admin.controllers;

import com.kurtomerfaruk.admin.models.Staff;
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
public class StaffController extends AbstractController<Staff> implements java.io.Serializable {

    private static final long serialVersionUID = -6030739683693104601L;

    @ManagedProperty("#{menuController}")
    private MenuController menuController;
    @ManagedProperty("#{addressController}")
    private AddressController addressController;
    @ManagedProperty("#{storeController}")
    private StoreController storeController;
    @ManagedProperty("#{storeController}")
    private StoreController storeIdController;

    /**
     *
     */
    public StaffController() {
        super(Staff.class);
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
     *
     * @return
     */
    public StoreController getStoreIdController() {
        return storeIdController;
    }

    /**
     *
     * @param storeIdController
     */
    public void setStoreIdController(StoreController storeIdController) {
        this.storeIdController = storeIdController;
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    @Override
    public void resetParents() {
        storeController.setSelected(null);
        storeIdController.setSelected(null);
        addressController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Store controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareStore(ActionEvent event) {
        if (this.getSelected() != null && storeController.getSelected() == null) {
            storeController.setSelected(this.getSelected().getStore());
        }
    }

    /**
     * Sets the "items" attribute with a collection of Payment entities that are
     * retrieved from Staff?cap_first and returns the navigation outcome.
     *
     */
    public void navigatePaymentList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Payment_items", this.getSelected().getPaymentList());
        }
        menuController.setPageLink("/payment/index");
        menuController.setPageName("Payment List");
    }

    /**
     * Sets the "items" attribute with a collection of Rental entities that are
     * retrieved from Staff?cap_first and returns the navigation outcome.
     *
     */
    public void navigateRentalList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Rental_items", this.getSelected().getRentalList());
        }
        menuController.setPageLink("/rental/index");
        menuController.setPageName("Rental List");
    }

    /**
     * Sets the "selected" attribute of the Store controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareStoreId(ActionEvent event) {
        if (this.getSelected() != null && storeIdController.getSelected() == null) {
            storeIdController.setSelected(this.getSelected().getStoreId());
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
