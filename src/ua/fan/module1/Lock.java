package ua.fan.module1;

import java.util.Arrays;

public class Lock {
    private final int[] array;

    public Lock(final int[] array) {
        this.array = array;
    }

    public int[] getArray() {
        return array.clone();
    }

    public void printArray(){
        System.out.println(Arrays.toString(getArray()));
    }

}
