package ru.job4j.iterator;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static java.lang.reflect.Array.get;

public class NonNullIterator implements Iterator<Integer> {

    private Integer[] data;
    private int index;

    public NonNullIterator(Integer[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        return index < data.length && data[index] != null;
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            return data[index++];
        } else {
            remove();
        }
        throw new NoSuchElementException();
    }

    @Override
    public void remove() {
        int indexToRemove = index + 1;
        final Integer[] newArray = new Integer[data.length - 1];
        System.arraycopy(data, 0, newArray, 0, indexToRemove);
        System.arraycopy(data, indexToRemove + 1, newArray, indexToRemove, newArray.length - indexToRemove);
        data = newArray;
    }
}
/**
 * Iterator<Integer> iterator = new NonNullIterator(new Integer[] {4, 2, null, null});
 * Методы:
 * - iterator.next() - возвращают только не-null объекты. В этом примере - это 4 и 2.
 * - iterator.hasNext() - возвращает true, только если в массиве есть не-null объекты справа
 * от указателя (дальше по направлению движения итератора к концу массива).
 * Указатель итератора при создании итератора располагается перед ячейкой с индексом [0].
 * Например, если мы вызовем два раза метод next(),
 * то указатель сместится вправо на два элемента и расположится между ячейками [1] и [2].
 * При вызове метода hasNext() - он вернет false, т.к. после указателя больше нет не-null объектов.
 * <p>
 * 1.  метод next в случае отсутствия элементов к возврату генерирует NoSuchElementException.
 * 2.  метод next должен возвращать верные значения вне зависимости от того,
 * вызвал ли перед этим программист метод hasNext. Аналогично для hasNext.
 * Результат работы ваших методов не должен зависеть от последовательности,
 * в которой программист вызывает методы, т.е. не полагайтесь на то,
 * что программист будет вызывать методы именно в том порядке в котором вы ожидаете.
 * 3. не допускайте дублирования кода. Если вы видите, что методы next и hasNext имеют одинаковый код,
 * то выносите этот код в отдельный метод и делайте уже его вызов.
 * 4. не используйте эксепшены для управления логикой вашей программы.
 * Они созданы для обработки критических ситуаций + очень дороги в создании
 * по сравнению с обычными объектами в Java.
 * 5. не оставляйте пустых методов в коде. Обратите внимание,
 * что метод remove объявлен как дефолтный - это значит,
 * что нет необходимости его реализовывать пустым, если вы не собираетесь переопределять его поведение.
 * В коде не должно быть пустых методов, если ваша программа не поддерживает какой-либо функционал,
 * задекларированный в интерфейсе - прокидывайте UnsupportedOperationException.
 * <p>
 *     Iterator.super.remove();
 * class IteratorImpl implements Iterator<Object> {
 * int current = top;
 * <p>
 * <p>
 * public boolean hasNext() {
 * return current != -1;
 * }
 * <p>
 * <p>
 * public Object next() {
 * return array[current--];
 * }
 * <p>
 * public void remove() {
 * top--;
 * final Object[] newArray = new Object[array.length - 1];
 * int indexToRemove = current + 1;
 * <p>
 * System.arraycopy(array, 0, newArray, 0, indexToRemove);
 * System.arraycopy(array, indexToRemove + 1, newArray, indexToRemove, newArray.length - indexToRemove);
 * <p>
 * array = newArray;
 * }
 */
