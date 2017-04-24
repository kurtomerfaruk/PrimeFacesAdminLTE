package com.kurtomerfaruk.admin.dao.impl;

import com.kurtomerfaruk.admin.dao.IFilmActorDAO;
import com.kurtomerfaruk.admin.models.FilmActor;

/**
 *
 * @author Omer Faruk KURT e-mail:kurtomerfaruk@gmail.com
 */
public class FilmActorDAOImpl extends GenericDAOImpl<FilmActor> implements IFilmActorDAO<FilmActor> {

    private static final long serialVersionUID = 3138160500099490215L;

    public FilmActorDAOImpl() {
        super(FilmActor.class);
    }
}
