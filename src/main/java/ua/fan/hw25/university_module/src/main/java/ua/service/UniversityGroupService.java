package ua.service;

import ua.dao.UniversityGroupDao;
import ua.entity.University;
import ua.entity.UniversityGroup;

import java.util.Arrays;

public class UniversityGroupService {
    public UniversityGroup createUniversityGroup(String name, University university) {
        return new UniversityGroup(name, university);
    }

    public void printUniversityGroupDaoResults(UniversityGroupDao universityGroupDao) {
        System.out.println("---> AMOUNT OF STUDENTS IN EACH GROUP:");
        for (Object[] object : universityGroupDao.getStudentsAmountInEachGroup()) {
            System.out.printf("Group name: %s%n Amount of students: %s%n%n", object[0], object[1]);
        }
    }

}
