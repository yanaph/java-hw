package ua.fan.dao;

import ua.fan.entity.StudyGroup;

import java.util.List;

public class StudyGroupDao extends AbstractDao<StudyGroup> {
    @Override
    protected void init() {
        aClass = StudyGroup.class;
    }

    public List<StudyGroup> getStudyGroupByName(String groupName) {
        return ENTITY_MANAGER.createNativeQuery(
                        "SELECT * FROM studyGroup WHERE UPPER(studyGroup.name) LIKE ?", StudyGroup.class)
                .setParameter(1, "%" + groupName.toUpperCase() + "%")
                .getResultList();
    }

    public List<Object[]> getStudentCountInEachGroup() {
        return ENTITY_MANAGER.createNativeQuery(
                        "SELECT studyGroup.name, COUNT(student.id) FROM studyGroup " +
                                "INNER JOIN student ON student.studyGroup_id = studyGroup.id " +
                                "GROUP BY studyGroup.name ORDER BY studyGroup.name ASC")
                .getResultList();
    }

    public List<Object[]> getAverageGradeOfEachGroup() {
        return ENTITY_MANAGER.createNativeQuery(
                        "SELECT studyGroup.name, AVG(grade.value) FROM studyGroup " +
                                "INNER JOIN student ON student.studyGroup_id = studyGroup.id " +
                                "INNER JOIN grade ON grade.student_id = student.id " +
                                "GROUP BY studyGroup.name ")
                .getResultList();
    }
}
