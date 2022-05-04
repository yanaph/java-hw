package ua.fan.hw14;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Util<V> implements Multiplier<Number> {
    private V value;

    public void printHashCode(V e) {
        System.out.println("HashCode: " + e.hashCode());
    }

    public void save(V value) {
        this.value = value;
    }

    public V get() {
        return value;
    }

    @Override
    public Number[] doubleValueIn(Number[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i].doubleValue() * array[i].doubleValue();
        }
        return array;
    }

    public <T extends Number, K extends Number> void sum(T one, K two) { // should work only with numbers
        System.out.println(one.doubleValue() + two.doubleValue());
    }

    public  double sumOfArray(List<? extends Number> list) {
        double s = 0.0;
        for (Number n : list) {
            s += n.doubleValue();
        }
        return s;
    }

    public void addNumbers(List<Integer> list) {
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
    }
}

interface Multiplier<T extends Number> {
    T[] doubleValueIn(T[] array);
}

public class Test {
    public static void main(String[] args) {
        Util<String> util = new Util<>();
        util.printHashCode("Test");
        util.save("Value");
        System.out.println(util.get());
        Number[] arr = {1, 2, 3, 4, 0, 5, 6, 7};
        System.out.println(Arrays.toString(util.doubleValueIn(arr)));
        System.out.println(util.sumOfArray(Arrays.asList(arr)));
        List<Integer> list = new ArrayList<>();
        util.addNumbers(list);
        System.out.println(Arrays.toString(list.toArray()));
        util.sum(22.1D, 200);
    }
}