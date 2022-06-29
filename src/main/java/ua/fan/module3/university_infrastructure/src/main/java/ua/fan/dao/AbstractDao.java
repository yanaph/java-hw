package ua.fan.dao;

import ua.fan.config.HibernateFactoryUtil;

import javax.persistence.EntityManager;


abstract class AbstractDao<T> {
    protected final static EntityManager ENTITY_MANAGER = HibernateFactoryUtil.getEntityManager();
    protected Class<T> aClass;

    public AbstractDao() {
        init();
    }

    protected abstract void init();
}

