package ru.job4j.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Balancer {
    public static void split(List<ArrayList<Integer>> nodes, Iterator<Integer> source) {
      int index = 0;
      while (source.hasNext()) {
          index = index == nodes.size() ? 0 : index;
          nodes.get(index++).add(source.next());
      }
       /** ArrayList<Integer> list = new ArrayList<>();
        nodes.iterator();
        while (source.hasNext()) {
            list.add(source.next());
        }
        new Iterator<>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                int count = index;
                while (list.get(index) == null) {
                    index++;
                    if (index == list.size()) {
                        index = 0;
                    }
                    if (index == count) {
                        return false;
                    }
                }
                return true;
            }

            @Override
            public Object next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (index == list.size()) {
                    index = 0;
                }
                return list.get(index++);
            }
        };*/
    }
}


/**
 * "как правильно прочитать коллекцию source" - это не коллекция в строгом понимании, это итератор.
 * Извлекаете из него элемент методом next(), а предварительно проверяете, что он есть методом hasNext().
 * Так вот, если в итераторе есть элемент к выдаче, то записываете его  в очередной список из nodes,
 * и так повторяете, пока итератор не ответит, что в нем закончились элементы к выдаче.
 * while (source.hasNext()) {
 * for (int j = 0; j < nodes.size(); j++) {
 * for (int k = 0; k < list.get(j); k++) {
 * Integer i = source.next();
 * }
 * <p>
 * ArrayList<Integer> list = new ArrayList<>();
 * <p>
 * source = new Iterator<>() {
 * int index = 0;
 *
 * @Override public boolean hasNext() {
 * int count = index;
 * while (list.get(index) == null) {
 * index++;
 * if (index == count || index == list.size()) {
 * return false;
 * }
 * }
 * return true;
 * }
 * @Override public Integer next() {
 * if (!hasNext()) {
 * throw new NoSuchElementException();
 * }
 * return list.get(index++);
 * }
 * };
 */