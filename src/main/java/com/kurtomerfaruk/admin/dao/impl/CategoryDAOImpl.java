package com.kurtomerfaruk.admin.dao.impl;

import com.kurtomerfaruk.admin.dao.ICategoryDAO;
import com.kurtomerfaruk.admin.models.Category;

/**
 *
 * @author Omer Faruk KURT e-mail:kurtomerfaruk@gmail.com
 */
public class CategoryDAOImpl extends GenericDAOImpl<Category> implements ICategoryDAO<Category> {

    private static final long serialVersionUID = 8841016216044790513L;

    public CategoryDAOImpl() {
        super(Category.class);
    }
}
