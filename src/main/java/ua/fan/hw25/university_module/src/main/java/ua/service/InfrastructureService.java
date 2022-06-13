package ua.service;

import ua.dao.*;
import ua.entity.University;
import ua.entity.UniversityGroup;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InfrastructureService {
    private final UniversityService universityService = new UniversityService();
    private final UniversityDao universityDao = new UniversityDao();
    private final UniversityGroupService universityGroupService = new UniversityGroupService();
    private final UniversityGroupDao universityGroupDao = new UniversityGroupDao();

    private final StudentService studentService = new StudentService();
    private final StudentDao studentDao = new StudentDao();
    private final CuratorService curatorService = new CuratorService();
    private final CuratorDao curatorDao = new CuratorDao();
    private final CourseService courseService = new CourseService();
    private final CourseDao courseDao = new CourseDao();

    public void createUniversityInfrastructure() {
        final List<University> universities = universityService.createUniversity();
        final University university1 = universities.get(0);
        final Set<UniversityGroup> universityGroups = new HashSet<>();

        UniversityGroup[] groups = addGroupsToUniversity(university1, universityGroups);
        university1.setUniversityGroups(universityGroups);
        addStudentsInEachGroup(groups);
        addCuratorToEachGroup(groups);
        setCoursesToEachStudent(groups);

        for (University university : universities) {
            universityDao.save(university);
        }
    }

    private void setCoursesToEachStudent(UniversityGroup[] groups) {
        for (UniversityGroup group: groups) {
            courseService.setCourse(group.getStudents(), 2);
        }
    }

    private void addCuratorToEachGroup(UniversityGroup[] groups) {
        for (UniversityGroup group : groups) {
            curatorService.addCurator(group);
        }
    }

    private void addStudentsInEachGroup(UniversityGroup[] groups) {
        for (UniversityGroup group : groups) {
            studentService.addStudents(group, 3);
        }
    }

    private UniversityGroup[] addGroupsToUniversity(University university, Set<UniversityGroup> universityGroups) {
        UniversityGroup[] arrayOfGroups = new UniversityGroup[3];
        for (int i = 0; i < 3; i++) {
             arrayOfGroups[i] =
                    universityGroupService.createUniversityGroup("universityGroup" + (i + 1), university);
            universityGroups.add(arrayOfGroups[i]);
        }
        return arrayOfGroups;
    }

    public void print() {
        courseService.printCourseDaoResults(courseDao, 2, 6);
        curatorService.printCuratorDaoResults(curatorDao, LocalDate.of(1970, 5, 5), 10);
        studentService.printStudentDaoResults(studentDao, 2);
        universityGroupService.printUniversityGroupDaoResults(universityGroupDao);
        universityService.printingAllUniversitiesInfrastructure(universityDao);
    }
}