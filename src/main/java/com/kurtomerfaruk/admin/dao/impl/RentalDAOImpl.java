package com.kurtomerfaruk.admin.dao.impl;

import com.kurtomerfaruk.admin.dao.IRentalDAO;
import com.kurtomerfaruk.admin.models.Rental;

/**
 *
 * @author Omer Faruk KURT e-mail:kurtomerfaruk@gmail.com
 */
public class RentalDAOImpl extends GenericDAOImpl<Rental> implements IRentalDAO<Rental> {

    private static final long serialVersionUID = -4926330873106256001L;

    public RentalDAOImpl() {
        super(Rental.class);
    }
}
