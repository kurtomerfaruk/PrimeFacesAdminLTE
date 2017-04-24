package com.kurtomerfaruk.admin.dao.impl;

import com.kurtomerfaruk.admin.dao.IAddressDAO;
import com.kurtomerfaruk.admin.models.Address;

/**
 *
 * @author Omer Faruk KURT e-mail:kurtomerfaruk@gmail.com
 */
public class AddressDAOImpl extends GenericDAOImpl<Address> implements IAddressDAO<Address> {

    private static final long serialVersionUID = -2759856581464537902L;

    public AddressDAOImpl() {
        super(Address.class);
    }
}
