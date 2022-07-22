package training.algorithms;

import java.util.Comparator;

public class QuickSort implements Sorter {

    public <T extends Comparable<T>> void sort(T[] array) {
        quickSort(array, 0, array.length - 1,Comparable::compareTo);
    }

    public <T> void sort(T[] array, Comparator<T> comparator) {
        quickSort(array, 0, array.length - 1, comparator);
    }

    private <T> void quickSort(T[] array, int lowIndex, int highIndex, Comparator<T> comparator) {

        if (lowIndex >= highIndex) {
            return;
        }
        T pivot = array[highIndex];

        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while (leftPointer < rightPointer) {
            while (comparator.compare(array[leftPointer], pivot) <= 0 && leftPointer < rightPointer) {
                leftPointer++;
            }
            while (comparator.compare(array[rightPointer], pivot) >= 0 && leftPointer < rightPointer) {
                rightPointer--;
            }
            swap(array, leftPointer, rightPointer);
        }
        swap(array, leftPointer, highIndex);

        quickSort(array, lowIndex, leftPointer - 1, comparator);
        quickSort(array, leftPointer + 1, highIndex, comparator);
    }


    private <T> void swap(T[] array, int index1, int index2) {
        T aux = array[index1];
        array[index1] = array[index2];
        array[index2] = aux;
    }
}
