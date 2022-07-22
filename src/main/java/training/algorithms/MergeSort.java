package training.algorithms;

import java.util.Comparator;

public class MergeSort implements Sorter {

    public <T extends Comparable<T>> void sort(T[] array) {
        mergeSort(array,Comparable::compareTo);
    }

    public <T> void sort(T[] array, Comparator<T> comparator) {
        mergeSort(array,comparator);
    }

    public <T> void mergeSort(T[] array,Comparator<T> comparator) {
        if (array.length == 1 || array.length==0)
            return;
        int middleIndex = array.length / 2;
        T[] leftArray = (T[]) new Object[middleIndex];
        T[] rightArray = (T[]) new Object[array.length - middleIndex];

        for (int i = 0; i < middleIndex; i++) {
            leftArray[i] = array[i];
        }
        //System.arraycopy(array, 0, leftArray, 0, middleIndex);
        for (int i = middleIndex; i < array.length; i++) {
            rightArray[i - middleIndex] = array[i];
        }
        //System.arraycopy(array, middleIndex, rightArray, 0, array.length - middleIndex);

        mergeSort(leftArray,comparator);
        mergeSort(rightArray, comparator);

        merge(array,leftArray,rightArray,comparator);

    }

    private <T> void merge(T[] array, T[] leftArray, T[] rightArray, Comparator<T> comparator) {
        int i = 0, j = 0, k = 0;
        while (i < leftArray.length && j < rightArray.length) {
            if(comparator.compare(leftArray[i],rightArray[j])<=0){
                array[k] = leftArray[i];
                i++;
            }else{
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while (i< leftArray.length){
            array[k]=leftArray[i];
            i++;
            k++;
        }
        while (j< rightArray.length){
            array[k]=rightArray[j];
            j++;
            k++;
        }
    }
}
