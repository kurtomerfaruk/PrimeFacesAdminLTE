package com.kurtomerfaruk.admin.dao.impl;

import com.kurtomerfaruk.admin.dao.IFilmTextDAO;
import com.kurtomerfaruk.admin.models.FilmText;

/**
 *
 * @author Omer Faruk KURT e-mail:kurtomerfaruk@gmail.com
 */
public class FilmTextDAOImpl extends GenericDAOImpl<FilmText> implements IFilmTextDAO<FilmText> {

    private static final long serialVersionUID = -5415565849998526477L;

    public FilmTextDAOImpl() {
        super(FilmText.class);
    }
}
