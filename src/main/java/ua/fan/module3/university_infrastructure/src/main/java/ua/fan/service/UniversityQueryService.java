package ua.fan.service;

import ua.fan.dao.DisciplineDao;
import ua.fan.dao.ProfessorDao;
import ua.fan.dao.StudentDao;
import ua.fan.dao.StudyGroupDao;
import ua.fan.entity.Professor;
import ua.fan.entity.StudyGroup;

import java.util.List;

public class UniversityQueryService {
    private static final StudyGroupDao studyGroupDao = new StudyGroupDao();
    private static final ProfessorDao professorDao = new ProfessorDao();
    private static final ProfessorService professorService = new ProfessorService();
    private static final DisciplineDao disciplineDao = new DisciplineDao();
    private static final StudentDao studentDao = new StudentDao();

    public void init() {
        System.out.println("---> GROUPS WITH NAMES THAT CONTAIN 'KNT':");
        List<StudyGroup> studyGroups = studyGroupDao.getStudyGroupByName("KNT");
        for (StudyGroup studyGroup : studyGroups) {
            System.out.println(studyGroup.getName());
        }

        System.out.println("\n---> AMOUNT OF STUDENTS IN EACH GROUP: ");
        final List<Object[]> studentCountInEachGroup = studyGroupDao.getStudentCountInEachGroup();
        for (Object[] info : studentCountInEachGroup) {
            System.out.printf("Group: %s%n Number of students: %s%n", info[0], info[1]);
        }

        System.out.println("\n---> AVERAGE GRADE IN EACH GROUP: ");
        final List<Object[]> averageGradeOfEachGroup = studyGroupDao.getAverageGradeOfEachGroup();
        for (Object[] info : averageGradeOfEachGroup) {
            System.out.printf("ID: %s%n Group: %s%n Avg grade: %s%n%n", info[0], info[1], info[2]);
        }

        System.out.println("---> FIND PROFESSOR BY FIRST OR LAST NAME:");
        final List<Professor> professors = professorDao.getByName("Polina");
        professors.forEach(professorService::printProfessorInfo);

        System.out.println("\n---> DISCIPLINE WITH MAX AND MIN GRADE: ");
        final List<Object[]> maxAndMinAvgGrade = disciplineDao.getDisciplineWithMaxAndMinAvgGrade();
        for (Object[] info : maxAndMinAvgGrade) {
            System.out.printf("Discipline: %s%n Avg grade: %s%n", info[0], info[1]);
        }

        System.out.println("\n---> STUDENTS WITH AVG GRADE > 90: ");
        final List<Object[]> studentWithCertainAvgGrade = studentDao.getStudentWithCertainAvgGrade(90);
        for (Object[] info : studentWithCertainAvgGrade) {
            System.out.printf("Last name: %s%n Avg grade: %s%n", info[0], info[1]);
        }
    }
}
