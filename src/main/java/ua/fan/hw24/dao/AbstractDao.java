package ua.fan.hw24.dao;

import ua.fan.hw24.config.HibernateFactoryUtil;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

abstract class AbstractDao<T> {
    protected Class<T> aClass;

    public AbstractDao() {
        init();
    }

    protected abstract void init();

    public void save(T value) {
        final EntityManager entityManager = HibernateFactoryUtil.getEntityManager();
        final EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(value);
        entityManager.flush();
        transaction.commit();
    }

    public T getById(Integer id) {
        final EntityManager entityManager = HibernateFactoryUtil.getEntityManager();
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<T> query = criteriaBuilder.createQuery(aClass);
        final Root<T> from = query.from(aClass);
        query.select(from);
        query.where(criteriaBuilder.equal(from.get("id"), id));
        return entityManager.createQuery(query).getSingleResult();
    }

    public List<T> getAll() {
        final EntityManager entityManager = HibernateFactoryUtil.getEntityManager();
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<T> query = criteriaBuilder.createQuery(aClass);
        final Root<T> entity = query.from(aClass);
        query.select(entity);
        return entityManager.createQuery(query).getResultList();
    }

//
//    public void delete(Integer id) {
//        final EntityManager entityManager = HibernateFactoryUtil.getEntityManager();
//        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//        CriteriaDelete<T> delete = criteriaBuilder.createCriteriaDelete(aClass);
//        final Root<T> from = delete.from(aClass);
//        delete.where(criteriaBuilder.equal(from.get("id"), id));
//        entityManager.createQuery(delete).executeUpdate();
//
//        //        entityManager.getTransaction().begin();
//        //        T value = entityManager.find(aClass, id);
//        //        entityManager.remove(value);
//        //        entityManager.getTransaction().commit();
//        //        entityManager.flush();
//    }

}
