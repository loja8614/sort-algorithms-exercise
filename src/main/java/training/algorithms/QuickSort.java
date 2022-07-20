package training.algorithms;

import java.util.Comparator;

public class QuickSort implements Sorter {

    public <T extends Comparable<T>> void sort(T[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public <T> void sort(T[] array, Comparator<T> comparator) {
        quickSortComparator(array, 0, array.length - 1,comparator);
    }

    private <T extends Comparable<T>> void quickSort(T[] array, int left, int right) {
        if (left >= right)
            return;
        int i = left, j = right;
        if (left != right) {
            int pivot = left;
            T aux;
            while (left!=right) {
                while (array[right].compareTo(array[pivot]) >= 0 && left < right)
                    right--;
                while (array[left].compareTo(array[pivot]) < 0 && left < right)
                    left++;
                if (right != left) {
                    aux = array[right];
                    array[right] = array[left];
                    array[left] = aux;
                }
                if (left == right) {
                    quickSort(array, i, left - 1);
                    quickSort(array, left + 1, j);
                }
            }
        } else
            return;
    }

    private  <T> void quickSortComparator(T[] array, int left, int right, Comparator<T> comparator) {
        if (left >= right)
            return;
        int i = left, j = right;
        if (left != right) {
            int pivot = left;
            T aux;
            while (left!=right) {
                while (comparator.compare(array[right],array[pivot]) >= 0 && left < right)
                    right--;
                while (comparator.compare(array[left],array[pivot]) < 0 && left < right)
                    left++;
                if (right != left) {
                    aux = array[right];
                    array[right] = array[left];
                    array[left] = aux;
                }
                if (left == right) {
                    quickSortComparator(array, i, left - 1,comparator);
                    quickSortComparator(array, left + 1, j,comparator);
                }
            }
        } else
            return;
    }
}
