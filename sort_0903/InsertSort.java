package sort_0903;

import java.util.Arrays;
import java.util.Random;

public class InsertSort {

    public static void insertSort(long[] array) {
        for(int i = 0;i < array.length-1;i++) {//外层循环表示有多少次选择的过程
            //假设第一个元素已经有序，就是从无序区间中选择一个出来插入到有序区间中
            //有序区间[0，i+1）  无序区间（i+1,array.length-1]
            long key = array[i+1];
            int j;
            for(j = i;j >= 0;j--) {//选出来的key这个元素跟有序区间的数从后往前相比较，
                if(key < array[j]){
                    array[j+1] = array[j];
                }else {
                    break;
                }

            }

            array[j+1] = key;

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
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }
}
