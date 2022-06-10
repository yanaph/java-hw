package ua.dao;

import ua.entity.Course;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class CourseDao extends AbstractDao<Course> {
    @Override
    protected void init() {
        aClass = Course.class;
    }

    public List<Course> getCertainDifficultyLvlCourses(Integer min, Integer max) {
        final CriteriaBuilder criteriaBuilder = ENTITY_MANAGER.getCriteriaBuilder();
        final CriteriaQuery<Course> query = criteriaBuilder.createQuery(aClass);
        final Root<Course> courseRoot = query.from(aClass);
        query.select(courseRoot).where(criteriaBuilder.between(courseRoot.get("difficultyLvl"), min, max));
        return ENTITY_MANAGER.createQuery(query).getResultList();
    }
}