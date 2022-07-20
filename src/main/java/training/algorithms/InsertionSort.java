package training.algorithms;

import java.util.Comparator;

public class InsertionSort implements Sorter {


    public <T extends Comparable<T>> void sort(T[] array) {
        T aux;
        for (int i = 1; i < array.length; i++) {
            aux = array[i];
            for (int j = i - 1; j >= 0 && array[j].compareTo(aux) > 0; j--) {
                array[j + 1] = array[j];
                array[j] = aux;
            }
        }
    }

    public <T> void sort(T[] array, Comparator<T> comparator) {
        T aux;
        for (int i = 1; i < array.length; i++) {
            aux = array[i];
            for (int j = i - 1; j >= 0 && comparator.compare(array[j], aux) > 0; j--) {
                array[j + 1] = array[j];
                array[j] = aux;
            }
        }

    }
}
