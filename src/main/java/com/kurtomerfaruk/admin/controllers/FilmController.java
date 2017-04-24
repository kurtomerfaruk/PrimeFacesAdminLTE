package com.kurtomerfaruk.admin.controllers;

import com.kurtomerfaruk.admin.models.Film;
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
public class FilmController extends AbstractController<Film> implements java.io.Serializable {

    private static final long serialVersionUID = 7631157329061673328L;

    @ManagedProperty("#{menuController}")
    private MenuController menuController;
    @ManagedProperty("#{languageController}")
    private LanguageController originalLanguageController;
    @ManagedProperty("#{languageController}")
    private LanguageController languageController;

    /**
     *
     */
    public FilmController() {
        super(Film.class);
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
    public LanguageController getOriginalLanguageController() {
        return originalLanguageController;
    }

    /**
     *
     * @param originalLanguageController
     */
    public void setOriginalLanguageController(LanguageController originalLanguageController) {
        this.originalLanguageController = originalLanguageController;
    }

    /**
     *
     * @return
     */
    public LanguageController getLanguageController() {
        return languageController;
    }

    /**
     *
     * @param languageController
     */
    public void setLanguageController(LanguageController languageController) {
        this.languageController = languageController;
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    @Override
    public void resetParents() {
        originalLanguageController.setSelected(null);
        languageController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Language controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareOriginalLanguageId(ActionEvent event) {
        if (this.getSelected() != null && originalLanguageController.getSelected() == null) {
            originalLanguageController.setSelected(this.getSelected().getOriginalLanguageId());
        }
    }

    /**
     * Sets the "selected" attribute of the Language controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareLanguageId(ActionEvent event) {
        if (this.getSelected() != null && languageController.getSelected() == null) {
            languageController.setSelected(this.getSelected().getLanguageId());
        }
    }

    /**
     * Sets the "items" attribute with a collection of FilmActor entities that
     * are retrieved from Film?cap_first and returns the navigation outcome.
     *
     */
    public void navigateFilmActorList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("FilmActor_items", this.getSelected().getFilmActorList());
        }
        menuController.setPage("/filmActor/index", this.getSelected().getTitle());

    }

    /**
     * Sets the "items" attribute with a collection of Inventory entities that
     * are retrieved from Film?cap_first and returns the navigation outcome.
     *
     */
    public void navigateInventoryList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Inventory_items", this.getSelected().getInventoryList());
        }
        menuController.setPage("/inventory/index", this.getSelected().getTitle());
    }

    /**
     * Sets the "items" attribute with a collection of FilmCategory entities
     * that are retrieved from Film?cap_first and returns the navigation
     * outcome.
     *
     */
    public void navigateFilmCategoryList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("FilmCategory_items", this.getSelected().getFilmCategoryList());
        }
        menuController.setPage("/filmCategory/index", this.getSelected().getTitle());
    }
}
