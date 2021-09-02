package sortTest_0902;

import java.util.Arrays;
import java.util.Random;

public class SelectSort {

    public static void selectSort(long[] array) {
        //表示有多少次选择的过程
        for (int i = 0; i < array.length - 1; i++) {

            //有序区间（arr.length-i，array.length]
            //无序区间[0，array.length-i）
            int maxIndex = 0;
            for (int j = 1; j < array.length - i - 1; j++) {
                if (array[j] > array[maxIndex]) {
                    maxIndex = j;
                }
            }
            //找出maxIndex表示无序区间最大的数的下标
            long tmp = array[maxIndex];
            array[maxIndex] = array[array.length - 1 - i];
            array[array.length - i - 1] = tmp;

        }

    }



    public static long[] randomArray() {
        Random random = new Random(20201018);
        long[] array = new long[10];
        for(int i = 0;i < 10;i++) {
            array[i] = random.nextInt(100);
        }
            return array;
    }

    public static void main(String[] args) {

        long[] array = randomArray();
        System.out.println(Arrays.toString(array));
        selectSort(array);
        System.out.println(Arrays.toString(array));
    }
}

