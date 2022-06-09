package ua.service;

import ua.dao.CourseDao;
import ua.entity.Course;
import ua.entity.Student;

import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class CourseService {
    private static final Random RANDOM = new Random();

    public void setCourse(Student student, int courseCount) {
        Set<Course> courses = new HashSet<>();
        for (int i = 0; i < courseCount; i++) {
            final Course course = new Course("Course-" + RANDOM.nextInt(1000));
            course.setStudentSet(Collections.singleton(student));
            courses.add(course);
        }
        student.setCourseSet(courses);
    }

    public void printCourseDaoResults(CourseDao courseDao, Integer minDifficultyLevel, Integer maxDifficultyLevel) {
        System.out.println("---> ALL COURSES");
        courseDao.getAll().forEach(course -> System.out.println(getFormattedCourseString(course.getName(), course.getDifficultyLvl())));
        System.out.printf("---> COURSES WITH DIFFICULTY LEVEL FROM %s TO %s%n", minDifficultyLevel, maxDifficultyLevel);
        courseDao.getCertainDifficultyLvlCourses(minDifficultyLevel, maxDifficultyLevel).forEach(course -> System.out.println(getFormattedCourseString(course.getName(), course.getDifficultyLvl())));
    }

    private String getFormattedCourseString(String name, Integer difficultyLevel) {
        return String.format("Name: %s%n Difficulty level: %s%n", name, difficultyLevel);
    }
}
