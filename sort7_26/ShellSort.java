package sort7_26;

import java.util.Arrays;

public class ShellSort {

    /**
     * 希尔排序
     * @param array 传入一个数组 相当于分组进行插入排序
     *  时间复杂度
     *   最坏  O(n^2)
     *    最好  O(n)
     *    平均 O(n^1.3)
     *    空间复杂度 O(1)
     *    不具有稳定性
     * */
    public static void shellSort(long[] array) {

        int gap = array.length / 2;

        while (true) {
           insertSortGap(array,gap);
           if(gap == 1) {
               break;
           }
           gap = gap /2;
        }
    }


    //分组插入排序
    public static void insertSortGap(long[] array,int gap) {

        for(int i = gap;i < array.length-1; i++) {

            long key = array[i];

            int j;
            for(j = i - gap;j >= 0;j = j  - gap) {
                if(key < array[j]) {
                    array[j+gap] = array[j];
                }else {
                    break;
                }
            }

            array[j+gap] = key;
        }
    }

    public static void main(String[] args) {

        long[] array = new long[6];
        array = new long[]{1,3,5,2,4,6};

        System.out.println(Arrays.toString(array));
        shellSort(array);
        System.out.println(Arrays.toString(array));

    }

}
