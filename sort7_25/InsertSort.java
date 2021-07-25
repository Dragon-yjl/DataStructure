package sort7_25;

import java.util.Arrays;

public class InsertSort {

    /**
     * 插入排序
     * @param array 输入一个数组ling[] array
     *  时间复杂度
     *  最好 O(n)   有序
     *  最坏  O(n^2)  逆序
     *  平均  O(n^2)  随机
     *   空间复杂度
     *   最好/最坏/平均  O(1)
     *              具备稳定性
     */
    public static void insertSort(long[] array) {

        for(int i = 0;i < array.length-1;i++) {

            long key = array[i+1];
            int j = i;
            for(;j >= 0;j--) {
                if(key < array[j]) {
                    array[j+1] = array[j];
                }else {
                    break;
                }
            }

            array[j+1] = key;

        }
    }


    public static void main(String[] args) {

        long[] array = new long[10];
        array = new long[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

        insertSort(array);

        System.out.println(Arrays.toString(array));
    }
}
