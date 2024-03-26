package ru.job4j.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

import static java.util.Spliterators.iterator;

public class CyclicIterator<T> implements Iterator<T> {

    private List<T> data;
    private int index;

    public CyclicIterator() {
    }

    public CyclicIterator(List<T> data) {
        this.data = data;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        if (index >= data.size()) {
            index = 0;
        }
        return !data.isEmpty();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        T element = data.get(index);
        index = (index + 1) % data.size();
        return element;
    }
}

