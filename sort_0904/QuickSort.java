package sort_0904;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    public static void quickSort(long[] array,int left,int right) {

        if(left > right) {
            return;
        }
        //tmp存放基准值
        long key = array[left];
        int i = left;
        int j = right;
        while (i != j) {
            //从右往左找，直到找到比tmp小的数
            while(array-[j] >= key && i < j) {
                j--;
            }

            //在从左往右找，直到找到比基准值大的值
            while (array[i] <= key && i < j) {
                i++;
            }
        }

        //找到位置，交换
        if(i < j) {
            long tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }

        //基准值归位
        array[left] = array[i];
        array[i] = key;

        //递归进行以上操作
        quickSort(array,left,i - 1);
        quickSort(array,i+1,right);

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
        int left = 0;
        int right = array.length;
        quickSort(array,left,right);
        System.out.println(Arrays.toString(array));
    }
}
