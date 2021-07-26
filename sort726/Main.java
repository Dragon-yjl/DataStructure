package sort726;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        long[] array = new long[]{3,5,7,2};
        QuickSort3.quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}
