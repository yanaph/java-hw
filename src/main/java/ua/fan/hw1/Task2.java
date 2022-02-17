package ua.fan.hw1;

public class Task2 {
    public static void main(String[] args) {
        System.out.println("----> Task 2:");
        String name = "Zieu Lin";
        if (name.length() > 7) {
            System.out.println("A name length is more than 7!" + "\n");
        } else if (name.length() < 7) {
            System.out.println("A name length is less than 7!" + "\n");
        } else {
            System.out.println("A name length is 7!" + "\n");
        }
    }
}
