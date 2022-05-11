package ua.fan.hw16;

import java.util.*;

import static ua.fan.hw16.ListMethods.*;

public class Main {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
    }

    public static void task1() {
        System.out.println("======== TASK 1 ========");
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();


        fillList(arrayList);
        fillList(linkedList);

        System.out.println("Time spent on choosing element 100 000 times: ");
        System.out.println("ArrayList: " + measureTime(arrayList));
        System.out.println("LinkedList: " + measureTime(linkedList));
    }

    public static void task2() {
        System.out.println("\n======== TASK 2 ========");
        System.out.println("Enter the string: ");
        String phrase;
        Scanner sc = new Scanner(System.in);
        phrase = sc.nextLine();

        Dictionary dictionary = new Dictionary(phrase);
        dictionary.printSortedDictionary();
    }

    public static void task3() {
        System.out.println("\n======== TASK 3 ========");
        String[] strings = new String[]{"one", "two", "three", "four"};
        printArray(new ArrayIterator<>(strings));
    }

    public static void task4() {
        System.out.println("\n======== TASK 4 ========");
        final List<Student> students = new LinkedList<>();
        students.add(new Student("Biryukova", "KNT-20-1", 2, 4.5));
        students.add(new Student("Klochko", "KNT-19-3", 3, 4.85));
        students.add(new Student("Lee", "KNT-17-2", 4, 2.9));
        students.add(new Student("Zhuk", "KNT-20-1", 2, 2.8));

        System.out.println("-----> All students:");
        students.forEach((System.out::println));

        System.out.println("-----> All students on the 2nd year:");
        printStudents(students, 2);

        System.out.println("-----> All transferred students:");
        transferStudents(students);
        students.forEach((System.out::println));
    }

    private static void printArray(ArrayIterator<Object> arr) {
        while (arr.hasNext()) {
            System.out.println(arr.next());
        }
    }

    private static void printStudents(List<Student> students, int course) {
        for (Student s : students) {
            if (s.getYear() == course) {
                System.out.println(s);
            }
        }
    }

    private static void transferStudents(List<Student> students) {
        students.removeIf(student -> student.getAvgGrade() < 3 || student.getYear() > 5);
        students.forEach(Student::increaseYear);
    }

}
