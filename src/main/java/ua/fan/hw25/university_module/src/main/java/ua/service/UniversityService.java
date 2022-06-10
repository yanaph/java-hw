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

    public void printingUniversityInfrastructure(UniversityDao universityDao) {
        universityDao.getAll().forEach(university -> {
            System.out.printf("UNIVERSITY: %s%n    GROUPS: %n", university.getUniName());
            university.getUniversityGroups().forEach(universityGroup -> {
                System.out.printf("--> Group: %s%n    > Curator: %s%n",
                        universityGroup.getGroupName(), universityGroup.getCurator().getFullName());
                universityGroup.getStudents().forEach(student -> {
                    System.out.printf("    > Student: %s%n",
                            student.getName());
                    System.out.println("      > Student's courses:");
                    student.getCourseSet().forEach(course -> {
                        System.out.printf("        Discipline: %s%n         Difficulty (0-10): %s%n",
                                course.getName(), course.getDifficultyLvl());
                    });
                });
                System.out.println();
            });
        });
    }
}

//    public void printingUniversityInfrastructure(UniversityDao universityDao) {
//        universityDao.getAll().forEach(university -> {
//            System.out.printf("UNIVERSITY: %s%n    GROUPS: %n", university.getUniName());
//            university.getUniversityGroups().forEach(universityGroup -> {
//                System.out.printf("--> Group name: %s%n    Curator: %s%n    Quantity of students: %s%n%n",
//                        universityGroup.getGroupName(), universityGroup.getCurator().getFullName(), universityGroup.getStudents().size());
//                if (universityGroup.getStudents().size() > 0) {
//                    universityGroup.getStudents().forEach(student -> {
//                        System.out.printf("---> Name: %s%n     Quantity of courses: $s%n",
//                                student.getName(), student.getCourseSet().size());
//                        if (student.getCourseSet().size() > 0) {
//                            System.out.println("      Student's courses:");
//                            student.getCourseSet().forEach(course -> {
//                                System.out.printf("----> Discipline: %s%n      Difficulty (0-10): %s%n",
//                                        course.getName(), course.getDifficultyLvl());
//                            });
//                        }
//                    });
//                }
//            });
//        });
//    }
//}