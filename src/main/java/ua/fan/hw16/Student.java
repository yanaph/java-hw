package ua.fan.hw16;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashMap;

public class Student {
    private String surname;
    private String group;
    private int year;
    private double avgGrade;

    public Student(String surname, String group, int year, double avgGrade) {
        if (year < 1 || year > 6) {
            throw new IllegalArgumentException("Invalid year value");
        } else if (avgGrade < 1 || avgGrade > 5) {
            throw new IllegalArgumentException("Invalid average grade value");
        }
        this.surname = surname;
        this.group = group;
        this.year = year;
        this.avgGrade = avgGrade;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year < 1 || year > 6)
            throw new IllegalArgumentException("Invalid year value");
        this.year = year;
    }

    public double getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(double avgGrade) {
        if (avgGrade < 1 || avgGrade > 5)
            throw new IllegalArgumentException("Invalid average grade");
        this.avgGrade = avgGrade;
    }

    @Override
    public String toString() {
        return surname +
                ", " + group +
                ", " + year +
                ", " + avgGrade;
    }

    public void increaseYear() {
        year++;
    }
}
