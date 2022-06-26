package ua.fan.dao;

import ua.fan.entity.Professor;

import java.util.List;

public class ProfessorDao extends AbstractDao<Professor> {
    @Override
    protected void init() {
        aClass = Professor.class;
    }

    public List<Professor> getByName(String name) {
        return ENTITY_MANAGER.createNativeQuery(
                        "SELECT * FROM professor WHERE UPPER(professor.firstName) LIKE ? " +
                                "OR UPPER(professor.lastName) LIKE ? ", Professor.class)
                .setParameter(1, "%" + name.toUpperCase() + "%")
                .setParameter(2, "%" + name.toUpperCase() + "%")
                .getResultList();
    }
}
