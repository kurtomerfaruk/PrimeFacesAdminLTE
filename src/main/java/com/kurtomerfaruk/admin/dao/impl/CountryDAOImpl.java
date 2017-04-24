package com.kurtomerfaruk.admin.dao.impl;

import com.kurtomerfaruk.admin.dao.ICountryDAO;
import com.kurtomerfaruk.admin.models.Country;

/**
 *
 * @author Omer Faruk KURT e-mail:kurtomerfaruk@gmail.com
 */
public class CountryDAOImpl extends GenericDAOImpl<Country> implements ICountryDAO<Country> {

    private static final long serialVersionUID = -4202483361388728236L;

    public CountryDAOImpl() {
        super(Country.class);
    }

}
