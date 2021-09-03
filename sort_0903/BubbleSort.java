package sort_0903;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {

    public static void bubbleSort(long[] array) {
        for(int i = 0;i < array.length-1;i++) {
            //外层循环表示冒泡的次数
            boolean flg = true;
            for(int j = 0;j < array.length-i-1;j++) {
                //内层循环表示从第一个开始冒泡
                //无序区间在前[0，array.length-i）
                //有序区间在后[array.length-i, array.length-1)
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
        long[] array = new long[11];
        for(int i = 0;i < 11;i++) {
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
