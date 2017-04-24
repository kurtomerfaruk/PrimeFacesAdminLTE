package com.kurtomerfaruk.admin.dao.impl;

import com.kurtomerfaruk.admin.dao.IFilmDAO;
import com.kurtomerfaruk.admin.models.Film;

/**
 *
 * @author Omer Faruk KURT e-mail:kurtomerfaruk@gmail.com
 */
public class FilmDAOImpl extends GenericDAOImpl<Film> implements IFilmDAO<Film> {

    private static final long serialVersionUID = -7050779765479554786L;

    public FilmDAOImpl() {
        super(Film.class);
    }
}
