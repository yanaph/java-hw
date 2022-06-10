package ua.dao;

import ua.entity.Curator;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.List;

public class CuratorDao extends AbstractDao<Curator> {
    @Override
    protected void init() {
        aClass = Curator.class;
    }

    public List<Curator> getCuratorsByCondition(LocalDate birthDate, Integer experience) {
        final CriteriaBuilder criteriaBuilder = ENTITY_MANAGER.getCriteriaBuilder();
        final CriteriaQuery<Curator> query = criteriaBuilder.createQuery(aClass);
        final Root<Curator> curatorRoot = query.from(aClass);
        Predicate[] predicates = new Predicate[2];
        predicates[0] = criteriaBuilder.lessThan(curatorRoot.get("birthDate"), birthDate);
        predicates[1] = criteriaBuilder.gt(curatorRoot.get("experience"), experience);
        query.select(curatorRoot).where(predicates);
        return ENTITY_MANAGER.createQuery(query).getResultList();
    }
}
