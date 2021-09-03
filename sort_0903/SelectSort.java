package sort_0903;

import java.util.Arrays;
import java.util.Random;

public class SelectSort {

    public static void selectSort(long[] array) {
        for(int i = 0;i < array.length-1;i++) {
            int maxIndex = 0;
            for(int j = 1;j < array.length-1-i;j++) {
                if(array[maxIndex] < array[j]) {
                    maxIndex = j;
                }
                //选出一个最大的值的下标
            }
            //有序区间在后面(array.length-i,array.length]
            //无序区间在前面[0，array.length-i)

            long tmp = array[maxIndex];
            array[maxIndex] = array[array.length-i-1];
            array[array.length-i-1] = tmp;

        }
    }


    public static void selectSort1(long[] array) {
        for(int i = 0;i < array.length-1;i++) {
            int minIndex = i;
            for(int j =i+1;j < array.length;j++) {
                if(array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }

            long tmp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = tmp;
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
        selectSort1(array);
        System.out.println(Arrays.toString(array));
    }
}
