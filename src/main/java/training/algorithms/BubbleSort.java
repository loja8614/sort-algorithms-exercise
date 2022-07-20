package training.algorithms;

import java.util.Comparator;

public class BubbleSort implements Sorter {

    public <T extends Comparable<T>> void sort(T[] array) {
        T aux;
        boolean cambios = false;
        while (true) {
            cambios=false;
            for (int i = 1; i < array.length; i++) {
                if (array[i].compareTo(array[i - 1]) < 0) {
                    aux = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = aux;
                    cambios=true;
                }
            }
            if (!cambios)
                break;
        }
    }

    public <T> void sort(T[] array, Comparator<T> comparator) {
        T aux;
        boolean cambios = false;
        while (true) {
            cambios=false;
            for (int i = 1; i < array.length; i++) {
                if (comparator.compare(array[i],array[i - 1]) < 0) {
                    aux = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = aux;
                    cambios=true;
                }
            }
            if (!cambios)
                break;
        }
    }
}
