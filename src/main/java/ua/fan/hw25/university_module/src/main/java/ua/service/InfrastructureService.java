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
        final UniversityGroup universityGroup1 =
                universityGroupService.createUniversityGroup("universityGroup1", university1);
        final UniversityGroup universityGroup2 =
                universityGroupService.createUniversityGroup("universityGroup2", university1);
        final UniversityGroup universityGroup3 =
                universityGroupService.createUniversityGroup("universityGroup3", university1);

        final Set<UniversityGroup> universityGroups = new HashSet<>();
        universityGroups.add(universityGroup1);
        universityGroups.add(universityGroup2);
        universityGroups.add(universityGroup3);
        university1.setUniversityGroups(universityGroups);

        studentService.addStudents(universityGroup1, 2);
        studentService.addStudents(universityGroup2, 4);

        curatorService.addCurator(universityGroup1);
        curatorService.addCurator(universityGroup2);

        universityGroup1.getStudents().forEach(student -> courseService.setCourse(student, 3));

        for (University university : universities) {
            universityDao.save(university);
        }
    }

    public void print() {
        courseService.printCourseDaoResults(courseDao, 2, 6);
        curatorService.printCuratorDaoResults(curatorDao, LocalDate.of(1995,1,1), 5);
        studentService.printStudentDaoResults(studentDao, 2);
        universityGroupService.printUniversityGroupDaoResults(universityGroupDao);
    }

}
