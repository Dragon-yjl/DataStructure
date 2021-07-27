package testDemo;

import java.util.Arrays;

public class newCoder_Test {

    public static int[] reOrderArray (int[] array) {
        int index = 0;
        int[] res = new int[array.length];

        for(int i = 0; i < array.length; i++) {
            if(array[i] %2 != 0) {
                res[index++] = array[i];
            }
        }
        for(int j = 0; j < array.length; j++) {
            if(array[j] %2 == 0) {
                res[index++] = array[j];
            }
        }
        return res;
    }

    public static int[] reOrderArray1 (int[] array) {

        StringBuffer strJ = new StringBuffer();
        StringBuffer strO = new StringBuffer();

        for(int i = 0;i < array.length; i++) {
            if(array[i] %2 != 0) {
                strJ.append(array[i]);
            }else {
                strO.append(array[i]);
            }
        }

        String str = strJ.append(strO.toString()).toString();

        for(int j = 0; j < array.length; j++) {
            array[j] = Integer.parseInt(str.substring(j,j+1));
        }

        return array;
    }

    public static void main(String[] args) {

        int[] array = new int[]{2,5,1,6,2,44,11,4,5,6,8,9,6,3,1};

        int[] array1 = reOrderArray(array);

        System.out.println(Arrays.toString(array1));
    }

}
