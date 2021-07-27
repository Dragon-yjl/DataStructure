package sort07_27;

import java.util.Arrays;

public class Main {


    public static void main(String[] args) {

        long[] array = new long[]{10,9,8,7,6,5,4,3,21,0};

        MergeSort.mergeSort(array);

        System.out.println(Arrays.toString(array));
    }
}
