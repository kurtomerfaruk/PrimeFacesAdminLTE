package com.kurtomerfaruk.admin.controllers;

import com.kurtomerfaruk.admin.models.FilmText;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Omer Faruk KURT e-mail:kurtomerfaruk@gmail.com
 */
@ManagedBean
@ViewScoped
public class FilmTextController extends AbstractController<FilmText> implements java.io.Serializable {

    private static final long serialVersionUID = -5723621125572193729L;

    /**
     *
     */
    public FilmTextController() {
        super(FilmText.class);
        columnNames();
        columnList();
    }
}
