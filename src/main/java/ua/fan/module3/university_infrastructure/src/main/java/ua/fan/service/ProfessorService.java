package ua.fan.service;

import ua.fan.entity.Professor;

public class ProfessorService {
    public void printProfessorInfo(Professor professor){
        System.out.printf("Name: %s %s%n Age: %s y.o%n",
                professor.getFirstName(), professor.getLastName(), professor.getAge());
    }
}
