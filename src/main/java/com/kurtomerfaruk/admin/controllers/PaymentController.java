package com.kurtomerfaruk.admin.controllers;

import com.kurtomerfaruk.admin.models.Payment;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

/**
 *
 * @author Omer Faruk KURT e-mail:kurtomerfaruk@gmail.com
 */
@ManagedBean
@ViewScoped
public class PaymentController extends AbstractController<Payment> implements java.io.Serializable {

    private static final long serialVersionUID = -9082447260725275636L;

    @ManagedProperty("#{customerController}")
    private CustomerController customerController;
    @ManagedProperty("#{staffController}")
    private StaffController staffController;
    @ManagedProperty("#{rentalController}")
    private RentalController rentalController;

    /**
     *
     */
    public PaymentController() {
        super(Payment.class);
        columnNames();
        columnList();
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
     *
     * @return
     */
    public RentalController getRentalController() {
        return rentalController;
    }

    /**
     *
     * @param rentalController
     */
    public void setRentalController(RentalController rentalController) {
        this.rentalController = rentalController;
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    @Override
    public void resetParents() {
        staffController.setSelected(null);
        rentalController.setSelected(null);
        customerController.setSelected(null);
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
     * Sets the "selected" attribute of the Rental controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareRentalId(ActionEvent event) {
        if (this.getSelected() != null && rentalController.getSelected() == null) {
            rentalController.setSelected(this.getSelected().getRentalId());
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
