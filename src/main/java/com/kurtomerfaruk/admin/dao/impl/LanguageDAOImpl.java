package com.kurtomerfaruk.admin.dao.impl;

import com.kurtomerfaruk.admin.dao.ILanguageDAO;
import com.kurtomerfaruk.admin.models.Language;

/**
 *
 * @author Omer Faruk KURT e-mail:kurtomerfaruk@gmail.com
 */
public class LanguageDAOImpl extends GenericDAOImpl<Language> implements ILanguageDAO<Language> {

    private static final long serialVersionUID = -3086478991096176988L;

    public LanguageDAOImpl() {
        super(Language.class);
    }

}
