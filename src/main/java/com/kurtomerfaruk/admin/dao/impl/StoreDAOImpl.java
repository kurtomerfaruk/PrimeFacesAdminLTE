package com.kurtomerfaruk.admin.dao.impl;

import com.kurtomerfaruk.admin.dao.IStoreDAO;
import com.kurtomerfaruk.admin.models.Store;

/**
 *
 * @author Omer Faruk KURT e-mail:kurtomerfaruk@gmail.com
 */
public class StoreDAOImpl extends GenericDAOImpl<Store> implements IStoreDAO<Store> {

    private static final long serialVersionUID = -2847335695659456925L;

    public StoreDAOImpl() {
        super(Store.class);
    }
}
