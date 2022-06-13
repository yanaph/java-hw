package ua.service;

import ua.dao.UniversityDao;
import ua.entity.Course;
import ua.entity.Student;
import ua.entity.University;
import ua.entity.UniversityGroup;

import java.util.*;

public class UniversityService {

    public List<University> createUniversity() {
        final University university1 = new University("university1");
        final University university2 = new University("university2");
        return Arrays.asList(university1, university2);
    }

    public void printingAllUniversitiesInfrastructure(UniversityDao universityDao) {
        System.out.println("---> UNIVERSITY INFRASTRUCTURE");
        if (universityDao.getAll()!=null){
            universityDao.getAll().forEach(this::printUniversity);
        } else {
            System.out.println("No universities in system yet.");
        }
    }

    private void printUniversity(University university) {
        System.out.printf("%nUNIVERSITY: %s%n    ", university.getUniName());
        if (university.getUniversityGroups() != null) {
            System.out.println("GROUPS: ");
            university.getUniversityGroups().forEach(this::printGroup);
        } else {
            System.out.println("No groups in university yet.");
        }
    }

    private void printGroup(UniversityGroup universityGroup) {
        System.out.printf("--> Group: %s%n",
                universityGroup.getGroupName());
        if (universityGroup.getCurator() != null) {
            System.out.printf("    > Curator: %s%n", universityGroup.getCurator().getFullName());
            if (universityGroup.getStudents() != null) {
                universityGroup.getStudents().forEach(this::printStudent);
            } else {
                System.out.println("      No students yet. Enrollment is still on!");
            }
        } else {
            System.out.println("    Curator hasn't been chosen yet.");
        }
    }

    private void printStudent(Student student) {
        System.out.printf("    > Student: %s%n",
                student.getName());
        if (student.getCourseSet() != null) {
            System.out.println("      > Student's courses:");
            student.getCourseSet().forEach(this::printCourse);
        } else {
            System.out.println("      Student hasn't chose his courses yet.");
        }
    }

    private void printCourse(Course course) {
        System.out.printf("        Discipline: %s%n         Difficulty (0-10): %s%n",
                course.getName(), course.getDifficultyLvl());
    }
}