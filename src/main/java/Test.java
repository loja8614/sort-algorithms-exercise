import training.algorithms.InsertionSort;

public class Test {
    public static void main(String[] args) {

        Integer[] array = new Integer[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        InsertionSort sort = new InsertionSort();

        sort.sort(array);

        for (Integer i : array
        ) {
            System.out.println("i = " + i);
        }

    }
}
