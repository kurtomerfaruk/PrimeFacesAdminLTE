package com.kurtomerfaruk.admin.dao.impl;

import com.kurtomerfaruk.admin.dao.IFilmCategoryDAO;
import com.kurtomerfaruk.admin.models.FilmCategory;

/**
 *
 * @author Omer Faruk KURT e-mail:kurtomerfaruk@gmail.com
 */
public class FilmCategoryDAOImpl extends GenericDAOImpl<FilmCategory> implements IFilmCategoryDAO<FilmCategory> {

    private static final long serialVersionUID = 9061566828274190051L;

    public FilmCategoryDAOImpl() {
        super(FilmCategory.class);
    }
}
