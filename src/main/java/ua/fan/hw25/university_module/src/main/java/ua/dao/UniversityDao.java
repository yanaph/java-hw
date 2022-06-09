package ua.dao;

import ua.entity.University;

public class UniversityDao extends AbstractDao<University> {
    @Override
    protected void init() {
        aClass = University.class;
    }
}