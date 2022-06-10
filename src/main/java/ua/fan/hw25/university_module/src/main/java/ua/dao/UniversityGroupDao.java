package ua.dao;

import ua.entity.UniversityGroup;

import java.util.List;

public class UniversityGroupDao extends AbstractDao<UniversityGroup> {
    @Override
    protected void init() {
        aClass = UniversityGroup.class;
    }

    public List<Object> getStudentsAmountInEachGroup() {
        return ENTITY_MANAGER.createNativeQuery(
                    "SELECT universityGroup.groupName, COUNT(universityGroup_student.student_id) " +
                            "FROM universityGroup " +
                            "INNER JOIN universityGroup_student " +
                            "ON universityGroup.id = universityGroup_student.universityGroup_id " +
                            "GROUP BY universityGroup.id")
                .getResultList();
    }
}
