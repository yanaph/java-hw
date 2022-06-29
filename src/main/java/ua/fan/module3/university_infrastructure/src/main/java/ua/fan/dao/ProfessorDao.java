package ua.fan.dao;

import ua.fan.config.HibernateFactoryUtil;
import ua.fan.entity.Professor;

import javax.persistence.EntityManager;
import java.util.List;

public class ProfessorDao {
    protected final static EntityManager ENTITY_MANAGER = HibernateFactoryUtil.getEntityManager();
    public List<Professor> getByName(String name) {
        return ENTITY_MANAGER.createNativeQuery(
                        "SELECT * FROM professor WHERE UPPER(professor.firstName) LIKE ? " +
                                "OR UPPER(professor.lastName) LIKE ? ", Professor.class)
                .setParameter(1, "%" + name.toUpperCase() + "%")
                .setParameter(2, "%" + name.toUpperCase() + "%")
                .getResultList();
    }
}
