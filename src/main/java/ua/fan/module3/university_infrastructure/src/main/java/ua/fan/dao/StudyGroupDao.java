package ua.fan.dao;

import ua.fan.entity.StudyGroup;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class StudyGroupDao extends AbstractDao<StudyGroup> {
    @Override
    protected void init() {
        aClass = StudyGroup.class;
    }

    public List<StudyGroup> getStudyGroupByName(String groupName) {
        final CriteriaBuilder criteriaBuilder = ENTITY_MANAGER.getCriteriaBuilder();
        final CriteriaQuery<StudyGroup> query = criteriaBuilder.createQuery(StudyGroup.class);
        final Root<StudyGroup> from = query.from(StudyGroup.class);
        query.select(from)
                .where(criteriaBuilder.like(from.get("name"), "%"+groupName+"%"));
        return ENTITY_MANAGER.createQuery(query).getResultList();
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
                        "SELECT studyGroup.id, studyGroup.name, AVG(grade.value) FROM studyGroup " +
                                "INNER JOIN student ON student.studyGroup_id = studyGroup.id " +
                                "INNER JOIN grade ON grade.student_id = student.id " +
                                "GROUP BY studyGroup.id ")
                .getResultList();
    }
}
