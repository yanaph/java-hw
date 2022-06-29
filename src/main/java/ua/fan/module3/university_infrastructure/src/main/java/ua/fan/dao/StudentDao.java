package ua.fan.dao;

import ua.fan.config.HibernateFactoryUtil;
import ua.fan.entity.Student;

import javax.persistence.EntityManager;
import java.util.List;

public class StudentDao {
    protected final static EntityManager ENTITY_MANAGER = HibernateFactoryUtil.getEntityManager();

    public List<Object[]> getStudentWithCertainAvgGrade(Integer avgGrade) {
            return ENTITY_MANAGER.createNativeQuery(
                            "SELECT student.lastName, AVG(grade.value) \n" +
                                    "FROM student INNER JOIN grade ON grade.student_id = student.id\n" +
                                    "GROUP BY student.lastName HAVING avg(grade.value) > ? ORDER BY student.lastName ASC")
                    .setParameter(1, avgGrade)
                    .getResultList();

    }
}
