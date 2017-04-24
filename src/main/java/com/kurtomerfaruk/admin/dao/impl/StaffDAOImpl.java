package com.kurtomerfaruk.admin.dao.impl;

import com.kurtomerfaruk.admin.dao.IStaffDAO;
import com.kurtomerfaruk.admin.models.Staff;
import javax.persistence.NoResultException;

/**
 *
 * @author Omer Faruk KURT e-mail:kurtomerfaruk@gmail.com
 */
public class StaffDAOImpl extends GenericDAOImpl<Staff> implements IStaffDAO<Staff> {
    private static final long serialVersionUID = 1602695723923335094L;

    public StaffDAOImpl() {
        super(Staff.class);
    }

    @Override
    public Staff login(String username, String password) {
        try {
            return (Staff) this.entityManager.createNamedQuery("Staff.findByUserPassword").setParameter("username", username).setParameter("password", password).getSingleResult();
        } catch (NoResultException ne) {
            return null;
        }
    }
}
