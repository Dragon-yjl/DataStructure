package sort07_25;

import java.util.Arrays;

public class SelectSort {

    /**
     * 选择排序
     * @param array 输入一数组
     *      *  时间复杂度：
     *      *  最好 O(n^2)  有序
     *      *   最坏 O(n^2)  逆序
     *      *   平均  O(n^2)
     *      *   空间复杂度
     *      *    最好/最坏/平均 O(1)
     *      *    不具备稳定性
     */
    public static void selectSort (long[] array) {

        //最外层循环表示执行多少次选择的过程
        //在无序区间选择一个最大的数
        for(int i = 0;i < array.length-1;i++) {

            //无序区间 [0, array.length-i)
            //有序区间 [array.length-i,array.length)
            int maxIndex = 0;//假设0号下表位置的元素是最大的
            for(int j = 1;j < array.length-i;j++) {
                if(array[maxIndex] < array[j]) {
                    maxIndex = j;
                }
                //这时候maxIndex 下表位置放的就是无序区间 最大的值
            }

            long t = array[maxIndex];
            array[maxIndex] = array[array.length-i-1];
            array[array.length-i-1] = t;

        }


    }

    public static void selectSort1(long[] array) {
        for(int i =0;i < array.length-1;i++) {
            int min = 0;

            int j =1;
            //无序区间 [0,array.length-i)
            //有序区间 [array.length-i,array.length)
            for(;j <array.length-i;j++) {
                if(array[min] > array[j]) {
                    min = j;
                }
            }

            long t = array[min];
            array[min] = array[j-1];
            array[j-1] = t;
        }
    }

    public static void main(String[] args) {

        long[] array = new long[10];
        array = new long[] {9,8,7,6,5,43,21,12,56,10};

        selectSort1(array);
        System.out.println(Arrays.toString(array));
    }

}
