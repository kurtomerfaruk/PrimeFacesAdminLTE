package com.kurtomerfaruk.admin.dao.impl;

import com.kurtomerfaruk.admin.dao.IInventoryDAO;
import com.kurtomerfaruk.admin.models.Inventory;

/**
 *
 * @author Omer Faruk KURT e-mail:kurtomerfaruk@gmail.com
 */
public class InventoryDAOImpl extends GenericDAOImpl<Inventory> implements IInventoryDAO<Inventory> {

    private static final long serialVersionUID = -1497520357355795460L;

    public InventoryDAOImpl() {
        super(Inventory.class);
    }
}
