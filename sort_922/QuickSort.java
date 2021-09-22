package sort_922;

import java.util.Arrays;

public class QuickSort {


    public static void quickSort(int[] array) {
        if(array.length == 0 || array.length ==1) {
            return;
        }

        sort(array,0,array.length-1);
    }


    public static void sort(int[] array,int left,int right) {
        if(left > right) {
            return;
        }

        int key = array[left];
        int i = left;
        int j = right;
        while (i < j) {
            while (array[j] >= key && i < j) {
                j--;
            }

            while (array[i] <= key && i < j) {
                i++;
            }

            if(i < j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] =tmp;
            }
        }

        array[left] = array[i];
        array[i] = key;


        sort(array,0,i-1);
        sort(array,i+1,right);
    }


    public static void main(String[] args) {
        int[] array = {1,5,2,6,7,2,8,3,9,34};

        System.out.println(Arrays.toString(array));
        quickSort(array);
        System.out.println(Arrays.toString(array));

    }
}
