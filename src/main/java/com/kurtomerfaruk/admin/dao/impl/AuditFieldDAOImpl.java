package com.kurtomerfaruk.admin.dao.impl;

import com.kurtomerfaruk.admin.audit.AuditField;
import com.kurtomerfaruk.admin.dao.IAuditFieldDAO;

/**
 *
 * @author Omer Faruk KURT
 * @Created on date 19/10/2016 15:18:12
 */
public class AuditFieldDAOImpl extends GenericDAOImpl<AuditField> implements IAuditFieldDAO {

    private static final long serialVersionUID = 5701429698554051319L;
    
    public AuditFieldDAOImpl(){
        super(AuditField.class);
    }

}
