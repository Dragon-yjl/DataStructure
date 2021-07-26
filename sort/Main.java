package sort;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        long[] array = new long[]{3,4,1,5,13,1,6,1,67,8,6,2};

        QuickSort2.quickSort(array);

        System.out.println(Arrays.toString(array));
    }
}
