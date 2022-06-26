package ua.fan.service;

import ua.fan.entity.Professor;

import java.util.List;

public class PrintInfoService {
    public void printInfo(List<Object[]> information){
        for (Object[] info : information) {
            System.out.printf("%s: %s%n", info[0], info[1]);
        }
    }
    public void printProfessorInfo(Professor professor){
        System.out.printf("Name: %s %s%n Age: %s y.o%n",
                professor.getFirstName(), professor.getLastName(), professor.getAge());
    }
}
