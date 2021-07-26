package sort07_26;

import java.util.Arrays;

import static sort07_26.QuickSort.*;

public class Main {

    public static void main(String[] args) {

        long[] array = new long[5];
        array = new long[]{4,2,7,5,6,9,2};

        quickSort(array);
        System.out.println(Arrays.toString(array));

    }
}
