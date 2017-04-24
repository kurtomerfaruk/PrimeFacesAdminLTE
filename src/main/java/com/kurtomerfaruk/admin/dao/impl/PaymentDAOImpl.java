package com.kurtomerfaruk.admin.dao.impl;

import com.kurtomerfaruk.admin.dao.IPaymentDAO;
import com.kurtomerfaruk.admin.models.Payment;

/**
 *
 * @author Omer Faruk KURT e-mail:kurtomerfaruk@gmail.com
 */
public class PaymentDAOImpl extends GenericDAOImpl<Payment> implements IPaymentDAO<Payment> {

    private static final long serialVersionUID = -2301386872154524429L;

    public PaymentDAOImpl() {
        super(Payment.class);
    }
}
