package com.kurtomerfaruk.admin.dao;

import com.kurtomerfaruk.admin.models.Staff;

/**
 *
 * @author Omer Faruk KURT e-mail:kurtomerfaruk@gmail.com
 * @param <T>
 */
public interface IStaffDAO<T> extends IGenericDAO<T>{
    public Staff login(String username,String password);
}
