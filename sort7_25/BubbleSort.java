package sort7_25;

import java.util.Arrays;

public class BubbleSort {

    /**
     * 冒泡排序
     * @param array 输入一个数组 long[] array
     *  时间复杂度：
     *  最好 O(n)  有序
     *   最坏 O(n^2)  逆序
     *   平均  O(n^2)
     *   空间复杂度
     *    最好/最坏/平均 O(1)
     *    具备稳定性
     */
    public static void bubbleSort(long[] array) {

        ///第一个for循环表示有多少次冒泡过程
        for(int i = 0;i < array.length-1;i++) {

            //无序区间 [0,array.length - 1)
            //有序区间[array.length - i,array,length)

            //每次交换之前，默认有序
            boolean isSorted = true;
            //进行冒泡过程
            for(int j = 0;j < array.length - 1 - i;j++) {
                if(array[j]  > array[j+1]) {
                    long t = array[j];
                    array[j] = array[j+1];
                    array[j+1] = t;

                    //变为false 表示发生了交换
                    isSorted = false;
                }
            }

            //如果没有发生交换 就break
            if (isSorted) {
                break;
            }
        }



    }


    public static void main(String[] args) {

        long[] array = new long[10];
        array = new long[] {9,8,7,6,5,43,21,12,56,10};

        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}
