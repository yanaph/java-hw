package ua.service;

import ua.dao.CuratorDao;
import ua.entity.Curator;
import ua.entity.UniversityGroup;

import java.time.LocalDate;
import java.util.Random;

public class CuratorService {
    private final static Random RANDOM = new Random();

    public void addCurator(UniversityGroup universityGroup) {
        final Curator curator = new Curator("Curator-" + RANDOM.nextInt(1000));
        universityGroup.setCurator(curator);
        curator.setUniversityGroup(universityGroup);
    }

    public void printCuratorDaoResults(CuratorDao curatorDao, LocalDate birthDate, Integer experience) {
        System.out.println("---> ALL CURATORS");
        curatorDao.getAll().forEach(curator -> System.out.println(getFormattedCuratorString(curator)));
        System.out.println("---> FILTER CURATOR BY CONDITION");
        curatorDao.getCuratorsByCondition(birthDate, experience)
                .forEach(curator -> System.out.println(getFormattedCuratorString(curator)));
    }

    private String getFormattedCuratorString(Curator curator) {
        return String.format("Name: %s%n Birthdate: %s%n Experience: %s y.%n Group: %s%n",
                curator.getFullName(), curator.getBirthDate(), curator.getExperience(),
                curator.getUniversityGroup().getGroupName());
    }
}