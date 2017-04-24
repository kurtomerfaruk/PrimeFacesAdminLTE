package com.kurtomerfaruk.admin.dao;

import com.kurtomerfaruk.admin.models.Menu;
import java.util.List;

/**
 *
 * @author Omer Faruk KURT e-mail:kurtomerfaruk@gmail.com
 * @param <T>
 */
public interface IMenuDAO<T> extends IGenericDAO<T> {

    List<Menu> searchMenuList(String text);
    Menu getTopMenu(Integer topMenuId);
}
