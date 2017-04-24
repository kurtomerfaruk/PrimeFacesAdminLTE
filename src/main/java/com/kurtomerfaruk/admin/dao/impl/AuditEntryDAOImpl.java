package com.kurtomerfaruk.admin.dao.impl;

import com.kurtomerfaruk.admin.audit.AuditEntry;
import com.kurtomerfaruk.admin.dao.IAuditEntryDAO;

/**
 *
 * @author Omer Faruk KURT
 * @Created on date 19/10/2016 15:16:25
 */
public class AuditEntryDAOImpl extends GenericDAOImpl<AuditEntry> implements IAuditEntryDAO {

    private static final long serialVersionUID = -5410267138639625241L;
    
    public AuditEntryDAOImpl(){
        super(AuditEntry.class);
    }

}
