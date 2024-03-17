package ru.job4j.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

import static java.util.Spliterators.iterator;

public class CyclicIterator<T> implements Iterator<T> {

    private List<T> data = new ArrayList<>();
    private final Iterator<T> iterator = data.iterator();
    private int index;

    public CyclicIterator(List<T> data) {
        this.data = data;
    }

    public CyclicIterator() {
    }
    @Override
    public boolean hasNext() {
        int count = 0;
        if (data.isEmpty()) {
            return false;
        }
        if (index >= data.size()) {
            for (T i : data) {
                count++;
                if (count == 20) {
                    break;
                }
            }
          data = (List<T>) iterator;
            index = 0;
        }
        return true;
    }

    private Iterator<T> iterator() {
        return new CyclicIterator<>();
    }

    @Override
    public T next() {
        index++;
        return iterator.next();
    }

    @Override
    public void remove() {
        iterator.remove();
    }

    @Override
    public void forEachRemaining(Consumer<? super T> action) {
        Iterator.super.forEachRemaining(action);
    }
}
