package ua.fan.dao;

import ua.fan.entity.Professor;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ProfessorDao extends AbstractDao<Professor> {
    @Override
    protected void init() {
        aClass = Professor.class;
    }

    public List<Professor> getByName(String name) {
        final CriteriaBuilder criteriaBuilder = ENTITY_MANAGER.getCriteriaBuilder();
        final CriteriaQuery<Professor> query = criteriaBuilder.createQuery(Professor.class);
        final Root<Professor> from = query.from(Professor.class);
        query.select(from).where(criteriaBuilder
                        .or(criteriaBuilder.equal(from.get("firstName"), name),
                                criteriaBuilder.equal(from.get("lastName"), name)));
        return ENTITY_MANAGER.createQuery(query).getResultList();
    }
}
