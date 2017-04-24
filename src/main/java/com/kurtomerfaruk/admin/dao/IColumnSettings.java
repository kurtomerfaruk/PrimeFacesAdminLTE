package com.kurtomerfaruk.admin.dao;

import com.kurtomerfaruk.admin.models.ColumnSettings;
import java.util.List;

/**
 *
 * @author Omer Faruk KURT e-mail:kurtomerfaruk@gmail.com
 * @param <T>
 */
public interface IColumnSettings<T> extends IGenericDAO<T> {

    public List<ColumnSettings> findByTableName(String simpleName);

}
