package ua.fan.service;

import ua.fan.action.ActionType;
import ua.fan.dao.DisciplineDao;
import ua.fan.dao.ProfessorDao;
import ua.fan.dao.StudentDao;
import ua.fan.dao.StudyGroupDao;
import ua.fan.entity.Professor;
import ua.fan.entity.StudyGroup;

import java.util.List;

public class MenuService {
    private static final InputService INPUT_SERVICE = new InputService();
    private static final StudyGroupDao STUDY_GROUP_DAO = new StudyGroupDao();
    private static final PrintInfoService PRINT_INFO_SERVICE = new PrintInfoService();
    private static final ProfessorDao PROFESSOR_DAO = new ProfessorDao();
    private static final DisciplineDao DISCIPLINE_DAO = new DisciplineDao();
    private static final StudentDao STUDENT_DAO = new StudentDao();

    public void actionMenu() {
        final String[] values = new String[ActionType.values().length];
        for (int i = 0; i < values.length; i++) {
        values[i] = ActionType.values()[i].getName();
        }
        int choice;
        do {
            System.out.println("\n\nChoose an action: ");
            for (int i = 0; i < values.length; i++) {
                System.out.printf("%d) %s%n", i + 1, values[i]);
            }
            choice = INPUT_SERVICE.getNumberInput();
            switch (choice) {
                case 1 -> findStudyGroupCase();
                case 2 -> getStudentCountCase();
                case 3 -> getAvgGradeCase();
                case 4 -> findProfessorCase();
                case 5 -> maxMinAvgGradeCase();
                case 6 -> getStudentWithCertainGradeCase();
            }
        } while (choice > 0 && choice < values.length);
    }

    private void getStudentWithCertainGradeCase() {
        System.out.print("Enter grade: ");
        int grade = INPUT_SERVICE.getNumberInput();
        final List<Object[]> studentWithCertainAvgGrade = STUDENT_DAO.getStudentWithCertainAvgGrade(grade);
        if (!studentWithCertainAvgGrade.isEmpty()) {
            PRINT_INFO_SERVICE.printInfo(studentWithCertainAvgGrade);
        } else {
            System.out.println("0 result was found");
        }
    }

    private void maxMinAvgGradeCase() {
        final List<Object[]> maxAndMinAvgGrade = DISCIPLINE_DAO.getDisciplineWithMaxAndMinAvgGrade();
        PRINT_INFO_SERVICE.printInfo(maxAndMinAvgGrade);
    }

    private void findProfessorCase() {
        System.out.print("Enter name: ");
        String professorsName = INPUT_SERVICE.getStringInput();
        final List<Professor> professors = PROFESSOR_DAO.getByName(professorsName);
        if (!professors.isEmpty()) {
            professors.forEach(System.out::println);
        } else {
            System.out.println("0 result was found");
        }
    }

    private void getAvgGradeCase() {
        final List<Object[]> averageGradeOfEachGroup = STUDY_GROUP_DAO.getAverageGradeOfEachGroup();
        PRINT_INFO_SERVICE.printInfo(averageGradeOfEachGroup);
    }

    private void getStudentCountCase() {
        final List<Object[]> studentCountInEachGroup = STUDY_GROUP_DAO.getStudentCountInEachGroup();
        PRINT_INFO_SERVICE.printInfo(studentCountInEachGroup);
    }

    private void findStudyGroupCase() {
        System.out.print("Enter name: ");
        String groupName = INPUT_SERVICE.getStringInput();
        List<StudyGroup> studyGroups = STUDY_GROUP_DAO.getStudyGroupByName(groupName);
        if (!studyGroups.isEmpty()) {
            studyGroups.forEach(studyGroup -> System.out.println(studyGroup.getName()));
        } else {
            System.out.println("0 result was found");
        }
    }
}
