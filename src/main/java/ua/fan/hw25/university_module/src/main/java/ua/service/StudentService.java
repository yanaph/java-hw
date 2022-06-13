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
        System.out.printf("---> GET STUDENT'S INFO BY ID: %s%n", id);
        for (Object[] object: studentDao.getStudentStudyInfoById(id)) {
            System.out.printf("Student's ID: %s%n Name: %s%n Group: %s%n Curator: %s%n University: %s%n%n",
                    object[0], object[1], object[2], object[3], object[4]);
        }
    }
}
