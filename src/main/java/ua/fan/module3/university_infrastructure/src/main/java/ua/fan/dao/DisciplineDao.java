package ua.fan.dao;

import ua.fan.config.HibernateFactoryUtil;
import ua.fan.entity.Discipline;

import javax.persistence.EntityManager;
import java.util.List;

public class DisciplineDao{
    protected final static EntityManager ENTITY_MANAGER = HibernateFactoryUtil.getEntityManager();

    public List<Object[]> getDisciplineWithMaxAndMinAvgGrade() {
        return ENTITY_MANAGER.createNativeQuery(
                        "(SELECT discipline.codeName, AVG(grade.value) FROM discipline " +
                                "INNER JOIN grade ON grade.discipline_id = discipline.id " +
                                "GROUP BY discipline.codeName " +
                                "ORDER BY AVG(grade.value) ASC " +
                                "LIMIT 1) " +
                                "UNION " +
                                "(SELECT discipline.codeName, AVG(grade.value) FROM discipline " +
                                "INNER JOIN grade ON grade.discipline_id = discipline.id " +
                                "GROUP BY discipline.codeName " +
                                "ORDER BY AVG(grade.value) DESC " +
                                "LIMIT 1)")
                .getResultList();
    }
}
