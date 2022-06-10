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
        System.out.println(Arrays.toString(universityGroupDao.getStudentsAmountInEachGroup().toArray()));
//        universityGroupDao.getStudentsAmountInEachGroup().forEach(System.out::println);
    }

}
