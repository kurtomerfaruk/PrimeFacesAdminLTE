package com.kurtomerfaruk.admin.controllers;

import com.kurtomerfaruk.admin.models.Category;
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
public class CategoryController extends AbstractController<Category> implements java.io.Serializable {

    private static final long serialVersionUID = -145600913693655598L;

    @ManagedProperty("#{menuController}")
    private MenuController menuController;
    
    /**
     *
     */
    public CategoryController() {
        super(Category.class);
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
     * Sets the "items" attribute with a collection of FilmCategory entities
     * that are retrieved from Category?cap_first and returns the navigation
     * outcome.
     *
     */
    public void navigateFilmCategoryList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("FilmCategory_items", this.getSelected().getFilmCategoryList());
        }
        menuController.setPage("/filmCategory/index", "Category List");
    }
}
