package ua.service;

import ua.dao.CuratorDao;
import ua.dao.StudentDao;
import ua.entity.Curator;
import ua.entity.Student;
import ua.entity.UniversityGroup;

import java.time.LocalDate;
import java.util.*;

public class StudentService {
    private static final Random RANDOM = new Random();
    public void addStudents(UniversityGroup group, int count) {
        Set<Student> studentSet = new HashSet<>();
        for (int i = 0; i < count; i++) {
            Student student = new Student("Student-" + RANDOM.nextInt(1000));
            student.setGroupSet(Collections.singleton(group));
            studentSet.add(student);
        }
        group.setStudents(studentSet);
    }
    public void printStudentDaoResults(StudentDao studentDao, Integer id) {
        System.out.printf("---> GET STUDENT'S INFO BY ID: %s%n%n", id);
        studentDao.getStudentStudyInfoById(id).forEach(System.out::println);
    }
}
