package com.kurtomerfaruk.admin.controllers;

import com.kurtomerfaruk.admin.models.Inventory;
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
public class InventoryController extends AbstractController<Inventory> implements java.io.Serializable {

    private static final long serialVersionUID = -4324161665977175993L;

    @ManagedProperty("#{menuController}")
    private MenuController menuController;
    @ManagedProperty("#{filmController}")
    private FilmController filmController;
    @ManagedProperty("#{storeController}")
    private StoreController storeController;

    /**
     *
     */
    public InventoryController() {
        super(Inventory.class);
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
    public FilmController getFilmController() {
        return filmController;
    }

    /**
     *
     * @param filmController
     */
    public void setFilmController(FilmController filmController) {
        this.filmController = filmController;
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
        filmController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Rental entities that are
     * retrieved from Inventory?cap_first and returns the navigation outcome.
     *
     */
    public void navigateRentalList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Rental_items", this.getSelected().getRentalList());
        }
        menuController.setPage("/rental/index", "Rental List");
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
     * Sets the "selected" attribute of the Film controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareFilmId(ActionEvent event) {
        if (this.getSelected() != null && filmController.getSelected() == null) {
            filmController.setSelected(this.getSelected().getFilmId());
        }
    }
}
