package ua.fan.hw16;

import java.util.List;
import java.util.Random;

public class ListMethods {
    final public static Random random = new Random();
    final static int NUMBER_OF_ELEMENTS = 100000;

    public static void fillList(List<Integer> list) {
        for (int i = 0; i < NUMBER_OF_ELEMENTS; i++) {
            list.add(random.nextInt());
        }
    }

    public static void chooseElementFromList(List<Integer> list) {
        for (int i = 0; i <NUMBER_OF_ELEMENTS; i++){
            list.get(random.nextInt(NUMBER_OF_ELEMENTS));
        }
    }

    public static long measureTime(List<Integer> list){
        long start = System.currentTimeMillis();
        chooseElementFromList(list);
        long finish = System.currentTimeMillis();
        return finish - start;
    }
}
