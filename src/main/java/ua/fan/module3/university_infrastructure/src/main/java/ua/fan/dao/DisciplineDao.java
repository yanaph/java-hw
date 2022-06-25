package ua.fan.dao;

import ua.fan.entity.Discipline;

import java.util.List;

public class DisciplineDao extends AbstractDao<Discipline> {
        @Override
        protected void init() {
            aClass = Discipline.class;
        }

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
