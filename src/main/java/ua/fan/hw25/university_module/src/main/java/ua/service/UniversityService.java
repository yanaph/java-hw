package ua.service;

import ua.dao.CourseDao;
import ua.dao.UniversityDao;
import ua.entity.University;
import ua.entity.UniversityGroup;

import java.util.*;

public class UniversityService {

    private UniversityService step1() {
        return this;
    }

    public List<University> createUniversity() {
        final University university1 = new University("university1");
        final University university2 = new University("university2");
        return Arrays.asList(university1, university2);
    }
}
