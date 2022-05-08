package ua.fan.hw16;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator<T> implements Iterator<T> {
    private final T[] arr;
    private int index;

    public ArrayIterator(T[] arr) {
        this.arr = arr;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < arr.length;
    }

    @Override
    public T next() {
        if (!hasNext()) {
          throw new NoSuchElementException("There is no next element.");
        }
        return arr[index++];
    }
}
