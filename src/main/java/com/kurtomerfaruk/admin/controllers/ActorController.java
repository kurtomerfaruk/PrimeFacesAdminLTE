package com.kurtomerfaruk.admin.controllers;

import com.kurtomerfaruk.admin.models.Actor;
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
public class ActorController extends AbstractController<Actor> implements java.io.Serializable {

    private static final long serialVersionUID = 3047947280907795325L;

    @ManagedProperty("#{menuController}")
    private MenuController menuController;

    /**
     *
     */
    public ActorController() {
        super(Actor.class);
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
     * Sets the "items" attribute with a collection of FilmActor entities that
     * are retrieved from Actor?cap_first and returns the navigation outcome.
     *
     */
    public void navigateFilmActorList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("FilmActor_items", this.getSelected().getFilmActorList());
        }
        menuController.setPageLink("/filmActor/index");
        menuController.setPageName("Film Actor List");
    }

}
