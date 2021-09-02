package sortTest_0902;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {

    public static void bubbleSort(long[] array) {

        boolean flg = true;
        for(int i = 0;i < array.length-1;i++) {

            for(int j = 0;j < array.length-1-i;j++) {
                if(array[j] > array[j+1]) {
                    long tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;

                    flg = false;
                }
            }

            if(flg) {
                break;
            }
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
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}
