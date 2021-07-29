package leetCode_07_29;

import java.util.Map;
import java.util.TreeMap;

public class Solution {

    //给定一个数组和一个目标值，求数组中两个数相加等于该数字的
    //两个数的下标
    public int[] twoSum(int[] nums,int target) {

        //map里面存的是数组的值和数组的下标
        Map<Integer,Integer> map = new TreeMap<>();
        //定义一个数组存放结果
        int[] res = new int[2];

        //从头开始遍历数组
        for(int i =0; i < nums.length;i++) {
            //定义一个数t等于目标值 - 数组中遍历到的值
            int t = target - nums[i];
            //如果map中包含这个减完之后的值，也就是说t和nums[i]就是要找的值
            if(map.containsKey(t)) {
                //找到了吧他们的下标填入res数组中
                res[0] = map.get(t);
                res[1] = i;
            }else {//找不到就把该元素和她的下标插入到map中，方便下一次查找
                map.put(nums[i],i);
            }
        }

        return res;
    }
}
