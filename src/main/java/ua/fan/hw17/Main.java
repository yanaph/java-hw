package ua.fan.hw17;

import ua.fan.hw17.model.Box;
import ua.fan.hw17.model.Item;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) {
//        task1();
//        task2();
//        task3();
//        task4();
        task5();


    }

    public static void task1() {
        String[] array = {"apple",
                "orange",
                "watermelon",
                "pear",
                "banana"
        };
        Arrays.stream(array)
                .sorted()
                .forEach(System.out::println);
    }

    public static void task2() {
        List<Integer> randomNumbers = new Random().ints(5, 0, 10)
                .collect(LinkedList::new, LinkedList::add, LinkedList::addAll);
        IntSummaryStatistics summaryStatistics = randomNumbers.stream()
                .filter(x -> x >= 0)
                .mapToInt(Integer::intValue)
                .summaryStatistics();
        System.out.println("Initial list:");
        System.out.println(randomNumbers);
        System.out.println("Summary statistics:");
        System.out.println("count:" + summaryStatistics.getCount() +
                "\nsum:" + summaryStatistics.getSum() +
                "\nmin:" + summaryStatistics.getMin() +
                "\naverage: " + String.format("%.2f", summaryStatistics.getAverage()) +
                "\nmax:" + summaryStatistics.getMax());
    }

    public static void task3() {
        final List<String> listOfDates = new LinkedList<>();
        listOfDates.add("2003/10/22");
        listOfDates.add("1997/09/12");
        listOfDates.add("2021/01/01");
        listOfDates.add("2016/11/23");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        boolean is2021YearPresentInList = listOfDates.stream()
                .map(d -> LocalDate.parse(d, dateTimeFormatter))
                .anyMatch(localDate -> localDate.getYear() == 2021);
        System.out.println("Initial list:");
        System.out.println(listOfDates);
        if (is2021YearPresentInList) {
            System.out.println("The list contains 2021 year");
        } else {
            System.out.println("The list doesn't contain 2021 year");
        }
    }

    public static void task4() {

        final List<Integer> listOfIntNumbers = new Random().ints(10, -50, 50)
                .collect(LinkedList::new, LinkedList::add, LinkedList::addAll);
        System.out.println("Initial list:");
        System.out.println(listOfIntNumbers);
        System.out.println("Minimal value is " + listOfIntNumbers.stream()
                .mapToInt(Integer::intValue)
                .reduce(Integer::min)
                .orElse(0));
        System.out.println();
    }

    public static void task5() {
        List<Box> boxList = createCollectionOfBox(3);
        for (Box box : boxList) {
            System.out.println(box);
        }
    }

    public static List<Box> createCollectionOfBox(int numberOfBoxes) {
        List<Box> listOfBoxes = new ArrayList<>();
        for (int i = 0; i < numberOfBoxes; i++) {
            listOfBoxes.add(new Box(createCollectionOfItems(3), (Math.random() + 1) * 10));
        }
        return listOfBoxes;
    }

    public static List<Item> createCollectionOfItems(int numberOfItems) {
        List<Item> listOfItems = new ArrayList<>();
        for (int i = 0; i < numberOfItems; i++) {
            listOfItems.add(new Item(Math.random() * 100, i + 1));
        }
        return listOfItems;
    }
}
