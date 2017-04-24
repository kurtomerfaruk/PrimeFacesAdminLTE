package com.kurtomerfaruk.admin.controllers;

import com.kurtomerfaruk.admin.models.Store;
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
public class StoreController extends AbstractController<Store> implements java.io.Serializable {

    private static final long serialVersionUID = 4743705798576239202L;
    @ManagedProperty("#{menuController}")
    private MenuController menuController;
    //@ManagedProperty("#{staffController}")
    private StaffController managerStaffIdController;
    //@ManagedProperty("#{addressController}")
    private AddressController addressIdController;

    /**
     *
     */
    public StoreController() {
        super(Store.class);
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
    public StaffController getManagerStaffIdController() {
        return managerStaffIdController;
    }

    /**
     *
     * @param managerStaffIdController
     */
    public void setManagerStaffIdController(StaffController managerStaffIdController) {
        this.managerStaffIdController = managerStaffIdController;
    }

    /**
     *
     * @return
     */
    public AddressController getAddressIdController() {
        return addressIdController;
    }

    /**
     *
     * @param addressIdController
     */
    public void setAddressIdController(AddressController addressIdController) {
        this.addressIdController = addressIdController;
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    @Override
    public void resetParents() {
        managerStaffIdController.setSelected(null);
        addressIdController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Staff controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareManagerStaffId(ActionEvent event) {
        if (this.getSelected() != null && managerStaffIdController.getSelected() == null) {
            managerStaffIdController.setSelected(this.getSelected().getManagerStaffId());
        }
    }

    /**
     * Sets the "selected" attribute of the Address controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareAddressId(ActionEvent event) {
        if (this.getSelected() != null && addressIdController.getSelected() == null) {
            addressIdController.setSelected(this.getSelected().getAddressId());
        }
    }

    /**
     * Sets the "items" attribute with a collection of Customer entities that
     * are retrieved from Store?cap_first and returns the navigation outcome.
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
     * retrieved from Store?cap_first and returns the navigation outcome.
     *
     */
    public void navigateStaffList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Staff_items", this.getSelected().getStaffList());
        }
        menuController.setPage("/staff/index", "Staff List");
    }

    /**
     * Sets the "items" attribute with a collection of Inventory entities that
     * are retrieved from Store?cap_first and returns the navigation outcome.
     *
     */
    public void navigateInventoryList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Inventory_items", this.getSelected().getInventoryList());
        }
        menuController.setPage("/inventory/index", "Inventory List");
    }

}
