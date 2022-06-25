package ua.fan.dao;

import ua.fan.entity.Student;

import java.util.List;

public class StudentDao extends AbstractDao<Student> {
    @Override
    protected void init() {
        aClass = Student.class;
    }

    public List<Object[]> getStudentWithCertainAvgGrade(Integer avgGrade) {
            return ENTITY_MANAGER.createNativeQuery(
                            "SELECT student.lastName, AVG(grade.value) " +
                                    "FROM student INNER JOIN grade ON grade.student_id = student.id " +
                                    "GROUP BY student.lastName HAVING avg(grade.value) > ?")
                    .setParameter(1, avgGrade)
                    .getResultList();

    }
}
