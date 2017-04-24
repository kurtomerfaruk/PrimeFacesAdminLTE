package com.kurtomerfaruk.admin.dao;

import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.primefaces.model.SortOrder;

/**
 *
 * @author Omer Faruk KURT
 * @param <T>
 */
public interface IGenericDAO<T> extends java.io.Serializable {

    T create(T t);

    T read(Object id);

    T update(T t);

    void delete(T t);

    void beginTransaction();

    void commit();

    void rollback();

    void closeTransaction();

    void commitAndCloseTransaction();

    void flush();

    List<T> findAll();

    public Predicate getFilterCondition(CriteriaBuilder cb, Root<T> root, Map<String, Object> filters,List<String> columnNameList);

    public List<T> loadLazy(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters,List<String> columnNameList);

    public int count(Map<String, Object> filters,List<String> columnNameList);
}
