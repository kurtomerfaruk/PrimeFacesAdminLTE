package com.kurtomerfaruk.admin.dao.impl;

import com.kurtomerfaruk.admin.dao.ICustomerDAO;
import com.kurtomerfaruk.admin.models.Customer;

/**
 *
 * @author Omer Faruk KURT e-mail:kurtomerfaruk@gmail.com
 */
public class CustomerDAOImpl extends GenericDAOImpl<Customer> implements ICustomerDAO<Customer> {

    private static final long serialVersionUID = -6958481401125841684L;

    public CustomerDAOImpl() {
        super(Customer.class);
    }
}
