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
        System.out.println("---> UNIVERSITY INFRASTRUCTURE");
        universityDao.getAll().forEach(university -> {
            System.out.printf("%nUNIVERSITY: %s%n    ", university.getUniName());
            if (university.getUniversityGroups() != null) {
                System.out.println("GROUPS: ");
                university.getUniversityGroups().forEach(universityGroup -> {
                    System.out.printf("--> Group: %s%n",
                            universityGroup.getGroupName());
                    if (universityGroup.getCurator() != null) {
                        System.out.printf("    > Curator: %s%n", universityGroup.getCurator().getFullName());
                        if (universityGroup.getStudents() != null) {
                            universityGroup.getStudents().forEach(student -> {
                                System.out.printf("    > Student: %s%n",
                                        student.getName());
                                if (student.getCourseSet() != null) {
                                    System.out.println("      > Student's courses:");
                                    student.getCourseSet().forEach(course -> {
                                        System.out.printf("        Discipline: %s%n         Difficulty (0-10): %s%n",
                                                course.getName(), course.getDifficultyLvl());
                                    });
                                } else {
                                    System.out.println("      Student hasn't chose his courses yet.");
                                }
                            });
                        } else {
                            System.out.println("      No students yet. Enrollment is still on!");
                        }
                    } else {
                        System.out.println("    Curator hasn't been chosen yet.");
                    }
                });
            } else {
                System.out.println("No groups in university yet.");
            }
        });
    }
}