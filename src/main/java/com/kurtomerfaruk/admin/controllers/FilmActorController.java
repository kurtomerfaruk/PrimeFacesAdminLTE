package com.kurtomerfaruk.admin.controllers;

import com.kurtomerfaruk.admin.models.FilmActor;
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
public class FilmActorController extends AbstractController<FilmActor> implements java.io.Serializable {

    private static final long serialVersionUID = 6340404159720989866L;

    @ManagedProperty("#{actorController}")
    private ActorController actorController;
    @ManagedProperty("#{filmController}")
    private FilmController filmController;

    /**
     *
     */
    public FilmActorController() {
        super(FilmActor.class);
        columnNames();
        columnList();
    }

    /**
     *
     * @return
     */
    public ActorController getActorController() {
        return actorController;
    }

    /**
     *
     * @param actorController
     */
    public void setActorController(ActorController actorController) {
        this.actorController = actorController;
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
        actorController.setSelected(null);
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
     * Sets the "selected" attribute of the Actor controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareActor(ActionEvent event) {
        if (this.getSelected() != null && actorController.getSelected() == null) {
            actorController.setSelected(this.getSelected().getActor());
        }
    }

}
