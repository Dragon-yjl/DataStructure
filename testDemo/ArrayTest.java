package testDemo;

import java.util.Arrays;

public class ArrayTest {

    //一个数组，把所有奇数放左边 偶数放右边
    public static void separate(long[] array) {

        int leftIndex = 0;
        int rightIndex = array.length-1;

        long[] newArray = new long[array.length];

        for(int i = 0;i < array.length; i++) {
            if(array[i]%2 != 0) {
                newArray[leftIndex++] = array[i];
            }else {
                newArray[rightIndex--] = array[i];
            }
        }

        for(int j = 0;j < array.length;j++) {
            array[j] = newArray[j];
        }
    }



    public static void main(String[] args) {

        long[] array = new long[]{2,5,1,6,2,4,5,6,8,9,6,3,1};

        separate(array);

        System.out.println(Arrays.toString(array));
    }
}
