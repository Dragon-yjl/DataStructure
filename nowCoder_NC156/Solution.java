package nowCoder_NC156;

import java.util.Arrays;

/**
 * 给定一个长度为 n 的整型数组 arr 和一个整数 k(k>1) 。
 * 已知 arr 中只有 1 个数出现一次，其他的数都出现 k 次。
 * 请返回只出现了 1 次的数。
 */

public class Solution {

    public static int foundOnceNumber (int[] arr, int k) {

        Arrays.sort(arr);

        for(int i = 0; i < arr.length-1;i++) {
            if(arr[i] == arr[i+1]) {
                i += k-1;
            }else {
                return arr[i];
            }
        }

        return arr[arr.length-1];
    }


    public static void main(String[] args) {
        int[] arr = {5,5,3,3,4,5,3};

        int res = foundOnceNumber(arr, 3);
        System.out.println(res);
    }
}
