package sortTest_0902;

import java.util.Arrays;
import java.util.Random;

public class InsertSort {
    /***
     * 插入排序
     * @param array 传入一个数组
     */
    public static void insertSort(long[] array){

        //[有序区间，无序区间]
        for(int i = 0;i < array.length-1;i++) {//表示需要比较多少次
            //有序区间[0,i+1）
            //无序区间[i+1，array.length-1]
            long key = array[i+1];

            //把无序区间第一个数拿出来跟有序区间从后往前比,从i到0
            int j;
            for(j = i; j >= 0; j--) {
                if(key < array[j]){
                    array[j + 1] = array[j];
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
