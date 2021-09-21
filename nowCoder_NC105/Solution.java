package nowCoder_NC105;



public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 如果目标值存在返回下标，否则返回 -1
     * @param nums int整型一维数组
     * @param target int整型
     * @return int整型
     */
    public static int search (int[] nums, int target) {
        // write code here
        int res = -1;

        if(nums == null || nums.length < 1) {
            return res;
        }
        int left = 0;
        int right = nums.length-1;

        while(left <= right) {
            int mid = (right - left)/2 + left;
            if(target < nums[mid]) {
                right = mid -1;
            }else if(target > nums[mid]) {
                left = mid + 1;
            }else {
                res = mid;
                right = mid-1;

            }
        }

        return res;
    }


    public static void main(String[] args) {
        int[] nums = {1,2,2,3,4,4,5,6,7,8,9};
        int search = search(nums, 2);
        System.out.println(search);

    }
}