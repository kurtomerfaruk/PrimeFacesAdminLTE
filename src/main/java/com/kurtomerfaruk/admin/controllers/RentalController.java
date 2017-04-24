package com.kurtomerfaruk.admin.controllers;

import com.kurtomerfaruk.admin.models.Rental;
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
public class RentalController extends AbstractController<Rental> implements java.io.Serializable {

    private static final long serialVersionUID = 12880110425446048L;
    @ManagedProperty("#{menuController}")
    private MenuController menuController;
    @ManagedProperty("#{inventoryController}")
    private InventoryController inventoryController;
    @ManagedProperty("#{customerController}")
    private CustomerController customerController;
    @ManagedProperty("#{staffController}")
    private StaffController staffController;

    /**
     *
     */
    public RentalController() {
        super(Rental.class);
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
    public InventoryController getInventoryController() {
        return inventoryController;
    }

    /**
     *
     * @param inventoryController
     */
    public void setInventoryController(InventoryController inventoryController) {
        this.inventoryController = inventoryController;
    }

    /**
     *
     * @return
     */
    public CustomerController getCustomerController() {
        return customerController;
    }

    /**
     *
     * @param customerController
     */
    public void setCustomerController(CustomerController customerController) {
        this.customerController = customerController;
    }

    /**
     *
     * @return
     */
    public StaffController getStaffController() {
        return staffController;
    }

    /**
     *
     * @param staffController
     */
    public void setStaffController(StaffController staffController) {
        this.staffController = staffController;
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    @Override
    public void resetParents() {
        staffController.setSelected(null);
        inventoryController.setSelected(null);
        customerController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Payment entities that are
     * retrieved from Rental?cap_first and returns the navigation outcome.
     *
     */
    public void navigatePaymentList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Payment_items", this.getSelected().getPaymentList());
        }
        menuController.setPageLink("/payment/index");
        menuController.setPageName("Rental List");
    }

    /**
     * Sets the "selected" attribute of the Staff controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareStaffId(ActionEvent event) {
        if (this.getSelected() != null && staffController.getSelected() == null) {
            staffController.setSelected(this.getSelected().getStaffId());
        }
    }

    /**
     * Sets the "selected" attribute of the Inventory controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareInventoryId(ActionEvent event) {
        if (this.getSelected() != null && inventoryController.getSelected() == null) {
            inventoryController.setSelected(this.getSelected().getInventoryId());
        }
    }

    /**
     * Sets the "selected" attribute of the Customer controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCustomerId(ActionEvent event) {
        if (this.getSelected() != null && customerController.getSelected() == null) {
            customerController.setSelected(this.getSelected().getCustomerId());
        }
    }
}
