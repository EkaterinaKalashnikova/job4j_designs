package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class NonNullIterator implements Iterator<Integer> {

    private final Integer[] data;
    private int index;

    public NonNullIterator(Integer[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        return index + 1 < data.length;
    }


    @Override
    public Integer next() {
        if (hasNext()) {
            while (data[index] == null) {
                index++;
            }
            return data[index++];
        }
        throw new NoSuchElementException();
    }
}

