package com.kurtomerfaruk.admin.dao.impl;

import com.kurtomerfaruk.admin.dao.ICityDAO;
import com.kurtomerfaruk.admin.models.City;

/**
 *
 * @author Omer Faruk KURT e-mail:kurtomerfaruk@gmail.com
 */
public class CityDAOImpl extends GenericDAOImpl<City> implements ICityDAO<City> {

    private static final long serialVersionUID = 7964273664088237086L;

    public CityDAOImpl() {
        super(City.class);
    }
}
