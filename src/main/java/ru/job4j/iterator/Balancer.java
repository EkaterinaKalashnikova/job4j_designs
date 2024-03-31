package ru.job4j.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Balancer {
    public static void split(List<ArrayList<Integer>> nodes, Iterator<Integer> source) {
        ArrayList<Integer> list = new ArrayList<>();
        while (source.hasNext()) {
            for (int j = 0; j < nodes.size(); j++) {
                for (int k = 0; k < list.get(j); k++) {
                      Integer i = source.next();
                    /** if (nodes.contains(i)) {
                       list.add(i);*/
                }
                source = new Iterator<>() {
                    int index = 0;

                    @Override
                    public boolean hasNext() {
                        int count = index;
                        while (list.get(index) == null) {
                            index++;
                            if (index == count || index == list.size()) {
                                return false;
                            }
                        }
                        return true;
                    }

                    @Override
                    public Integer next() {
                        if (!hasNext()) {
                            throw new NoSuchElementException();
                        }
                        return list.get(index++);
                    }
                };
            }
        }
    }
}


