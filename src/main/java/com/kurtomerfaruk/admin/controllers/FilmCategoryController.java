package com.kurtomerfaruk.admin.controllers;

import com.kurtomerfaruk.admin.models.FilmCategory;
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
public class FilmCategoryController extends AbstractController<FilmCategory> implements java.io.Serializable {

    private static final long serialVersionUID = 9187791059045889750L;

    @ManagedProperty(value = "#{categoryController}")
    private CategoryController categoryController;
    @ManagedProperty(value = "#{filmController}")
    private FilmController filmController;

    /**
     *
     */
    public FilmCategoryController() {
        super(FilmCategory.class);
        columnNames();
        columnList();
    }

    /**
     *
     * @return
     */
    public CategoryController getCategoryController() {
        return categoryController;
    }

    /**
     *
     * @param categoryController
     */
    public void setCategoryController(CategoryController categoryController) {
        this.categoryController = categoryController;
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
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    @Override
    public void resetParents() {
        filmController.setSelected(null);
        categoryController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Film controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareFilm(ActionEvent event) {
        if (this.getSelected() != null && filmController.getSelected() == null) {
            filmController.setSelected(this.getSelected().getFilm());
        }
    }

    /**
     * Sets the "selected" attribute of the Category controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCategory(ActionEvent event) {
        if (this.getSelected() != null && categoryController.getSelected() == null) {
            categoryController.setSelected(this.getSelected().getCategory());
        }
    }

}
