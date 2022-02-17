package ua.fan.module1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n------------------ PART 1 ------------------");
        Scanner scanner = new Scanner(System.in);

        int[] array = new int[conditionalArrayLengthRequest(scanner)];
        fillArray(array);
        System.out.println(Arrays.toString(array));

        if (sortingOrderRequest(scanner, array).equals("a")){
            sortInAscendingOrder(array);
        } else {
            sortInDescendingOrder(array);
        }
        System.out.println(Arrays.toString(array));

        System.out.println("\nNow let's cube every third element in the array!");
        cubeEveryThirdElement(array);
        System.out.println(Arrays.toString(array));

        System.out.println("\n------------------ PART 2 ------------------");
        int[] arr = new int[arrayLengthRequest(scanner)];
        arrayElementsValueRequest(scanner, arr);

        Lock lock = new Lock(arr);
        System.out.print("Array: ");
        lock.printArray();
        changeArrayElement(scanner, lock.getArray());
        System.out.print("Result: ");
        lock.printArray();

        scanner.close();
    }

    private static void fillArray(int[] array) {
        int n = 100; //интервал [-n;n], тоесть [-100;100]
        for (int j = 0; j < array.length; j++) {
            array[j] = (int) (Math.random() * (n * 2 + 1) - n);
        }
    }

    private static void sortInAscendingOrder(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }

    private static void sortInDescendingOrder(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }

    private static void cubeEveryThirdElement(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if ((i + 1) % 3 == 0) {
                array[i] = (int) (Math.pow(array[i], 3));
            }
        }
    }

    private static int conditionalArrayLengthRequest (Scanner sc){
        int length = 0;
        do {
            System.out.print("\nEnter length of an array (more or equals to 10): ");
            if (sc.hasNextInt()) {
                length = sc.nextInt();
                if (length < 10) {
                    System.out.println("Number is less than 10. Try again!");
                }
            } else {
                System.out.println("You have entered wrong data type. Try again!");
            }
        } while (length<10);
        return length;
    }

    private static String sortingOrderRequest (Scanner sc, int[] arr){
        String order;
        do {
            System.out.println("\nLet's sort this array! Do you want to sort it in ascending or descending order?");
            System.out.print("Enter your choice (a/d): ");
            order = sc.next();
            if (order.equals("a") || order.equals("d")) {
                break;
            } else {
                System.out.println("You have entered wrong symbol. Try again!");
            }
        } while (!order.equals("a") || !order.equals("d"));
        return order;
    }

    private static int arrayLengthRequest(Scanner sc) {
        int length = 0;
        do {
            System.out.print("\nEnter length of an array: ");
            if (sc.hasNextInt()) {
                length = sc.nextInt();
                if (length < 1) {
                    System.out.println("Number is less than 1. Try again!");
                }
            } else {
                System.out.println("You have entered wrong data type. Try again!");
                sc.nextLine();
            }
        } while (length < 1);
        return length;
    }

    private static void arrayElementsValueRequest(Scanner sc, int[] array) {
        boolean filled;
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            filled = false;
            do {
                System.out.print("[" + i + "] = ");
                if (scanner.hasNextInt()) {
                    array[i] = scanner.nextInt();
                    filled = true;
                } else {
                    System.out.println("You have entered wrong data type. Try again!");
                    scanner.nextLine();
                }
            } while (!filled);
        }
    }

    private static void changeArrayElement(Scanner sc, int[] array) {
        int index = -1, newValue;
        do {
            System.out.print("\nEnter an index of element which you want to change: ");
            if (sc.hasNextInt()) {
                index = sc.nextInt();
                if (index < 0 || index > array.length - 1) {
                    System.out.println("Array index out of bounds. Try again!");
                    sc.nextLine();
                }
            } else {
                System.out.println("You have entered wrong data type. Try again!");
                sc.nextLine();
            }
        } while (index < 0 || index > array.length - 1);

        boolean assigned = false;
        do {
            System.out.print("Enter a value to assign: ");
            if (sc.hasNextInt()) {
                newValue = sc.nextInt();
                array[index] = newValue;
                assigned = true;
            } else {
                System.out.println("You have entered wrong data type. Try again!");
                sc.nextLine();
            }
        } while (!assigned);
    }
}