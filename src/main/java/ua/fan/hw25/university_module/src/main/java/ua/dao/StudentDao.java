package ua.dao;

import ua.entity.Curator;
import ua.entity.Student;
import ua.entity.UniversityGroup;

import java.util.List;

public class StudentDao extends AbstractDao<Student> {
    @Override
    protected void init() {
        aClass = Student.class;
    }

    public List<Object> getStudentStudyInfoById(Integer id) {
        return ENTITY_MANAGER.createNativeQuery(
                "SELECT student.id, student.name, universityGroup.groupName, curator.fullName, university.uniName " +
                        "FROM curator INNER JOIN (university " +
                        "INNER JOIN (universityGroup " +
                        "INNER JOIN (student INNER JOIN universityGroup_student " +
                        "ON student.id = universityGroup_student.student_id) " +
                        "ON universityGroup.id = universityGroup_student.universityGroup_id) " +
                        "ON university.id = universityGroup.university_id) " +
                        "ON curator.id = universityGroup.curator_id WHERE student.id = ?")
                .setParameter(1, id)
                .getResultList();
    }
}