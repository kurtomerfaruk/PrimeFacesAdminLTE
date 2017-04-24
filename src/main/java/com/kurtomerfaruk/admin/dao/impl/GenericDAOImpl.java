package com.kurtomerfaruk.admin.dao.impl;

import com.kurtomerfaruk.admin.dao.IGenericDAO;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.primefaces.model.SortOrder;

/**
 *
 * @author Omer Faruk KURT e-mail:kurtomerfaruk@gmail.com
 * @param <T>
 */
public class GenericDAOImpl<T> implements IGenericDAO<T> {

    private static final long serialVersionUID = -4745715813453134429L;

    private Class<T> entityClass;

    protected static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ADMIN_PU");
    protected EntityManager entityManager;

    public GenericDAOImpl() {
        entityManager = emf.createEntityManager();
    }

    public GenericDAOImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
        entityManager = emf.createEntityManager();
    }

    @Override
    public T create(T t) {
        this.entityManager.persist(t);
        return t;
    }

    @Override
    public T read(Object id) {
        return this.entityManager.find(entityClass, id);
    }

    @Override
    public T update(T t) {
        return this.entityManager.merge(t);
    }

    @Override
    public void delete(T t) {
        t = this.entityManager.merge(t);
        this.entityManager.remove(t);
    }

    @Override
    public List<T> loadLazy(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters, List<String> columnNameList) {
        CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(entityClass);
        Root<T> myObj = cq.from(entityClass);
        cq.where(getFilterCondition(cb, myObj, filters, columnNameList));
        if (sortField != null) {
            if (sortField.contains(".")) {
                String[] sortFields = sortField.split(Pattern.quote("."));
                if (sortOrder.equals(SortOrder.ASCENDING)) {
                    cq.orderBy(cb.asc(myObj.get(sortFields[0]).get(sortFields[1])));
                } else if (sortOrder.equals(SortOrder.DESCENDING)) {
                    cq.orderBy(cb.desc(myObj.get(sortFields[0]).get(sortFields[1])));
                }
            } else {
                if (sortOrder.equals(SortOrder.ASCENDING)) {
                    cq.orderBy(cb.asc(myObj.get(sortField)));
                } else if (sortOrder.equals(SortOrder.DESCENDING)) {
                    cq.orderBy(cb.desc(myObj.get(sortField)));
                }
            }
        }
        return this.entityManager.createQuery(cq).setFirstResult(first).setMaxResults(pageSize).getResultList();
    }

    @Override
    public Predicate getFilterCondition(CriteriaBuilder cb, Root<T> root, Map<String, Object> filters, List<String> columnNameList) {
        Predicate filterCondition = cb.conjunction();
        String wildCard = "%";
        for (Map.Entry<String, Object> filter : filters.entrySet()) {
            String value = wildCard + filter.getValue() + wildCard;
            if (!filter.getValue().equals("")) {
                if (filter.getKey().contains(".")) {
                    String[] parts = filter.getKey().split(Pattern.quote("."));
                    String part1 = parts[0];
                    String part2 = parts[1];
                    javax.persistence.criteria.Path<String> path = (javax.persistence.criteria.Path<String>) root.get(part1).get(part2).as(String.class);
                    filterCondition = cb.and(filterCondition, cb.like(path, value));
                } else {
                    if (filter.getKey().equals("globalFilter")) {
                        Predicate[] pre = new Predicate[columnNameList.size()];
                        for (int i = 0; i < columnNameList.size(); i++) {
                            String get = columnNameList.get(i);
                            javax.persistence.criteria.Path<String> path = root.get(get);
                            Predicate p = cb.like(path, value);
                            pre[i] = p;
                        }
                        filterCondition = cb.or(pre);
                    } else {
                        javax.persistence.criteria.Path<String> path = root.get(filter.getKey());
                        filterCondition = cb.and(filterCondition, cb.like(path, value));
                    }

                }

            }

        }
        return filterCondition;
    }

    @Override
    public int count(Map<String, Object> filters, List<String> columnNameList) {
        CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<T> myObj = cq.from(entityClass);
        cq.where(getFilterCondition(cb, myObj, filters, columnNameList));
        cq.select(cb.count(myObj));
        return this.entityManager.createQuery(cq).getSingleResult().intValue();
    }

    @Override
    public void beginTransaction() {
        /*if (entityManager == null & !entityManager.isOpen()) {
         entityManager = emf.createEntityManager();
         }*/
        if (!entityManager.getTransaction().isActive()) {

            entityManager = emf.createEntityManager();
        }
        entityManager.getTransaction().begin();
    }

    @Override
    public void commit() {
        if (entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().commit();
        }
    }

    @Override
    public void rollback() {
        if (entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void closeTransaction() {
        entityManager.close();
    }

    @Override
    public void commitAndCloseTransaction() {
        commit();
        closeTransaction();
    }

    @Override
    public void flush() {
        entityManager.flush();
    }

    @Override
    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = this.entityManager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return this.entityManager.createQuery(cq).getResultList();
    }

}
