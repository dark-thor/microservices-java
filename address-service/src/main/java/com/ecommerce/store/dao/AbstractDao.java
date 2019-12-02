package com.ecommerce.store.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

/**
 * @author Uday Kiran Thota (tudaykr@yahoo.com)
 */

public abstract class AbstractDao<PK extends Serializable, T> {

    private final Class<T> persistentClass;

    @SuppressWarnings("unchecked")
    public AbstractDao(){
        this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    @PersistenceContext
    private EntityManager entityManager;

    protected EntityManager getEntityManager(){
        return entityManager;
    }

    @SuppressWarnings("unchecked")


    public T getByKey(PK key) {
        return (T) entityManager.find(persistentClass, key);
    }

    public void persist(T entity) throws ConstraintViolationException{
        entityManager.persist(entity);
    }

    public void remove(T entity) {
        entityManager.remove(entity);
    }

    protected CriteriaBuilder createCriteriaBuilder(){
        return entityManager.getCriteriaBuilder();
    }

}