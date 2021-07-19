package stackDemo7_19;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，
 * 请判断第二个序列是否为该栈的弹出顺序
 * 思想：需要两个序列和一个栈，
 * 第一步，从pop弹出序列取出一个元素，然后看栈里面
 * 有没有元素，①栈里面没有元素，从push压入序列中取出一个元素比较
 * ②如果相等，全部弹出去
 * ③如果不相等，再从push压入序列中取出一个元素压入栈中继续比较
 * 直到push压入序列为空，栈为空，pop弹出序列为空·就正确
 */
public class Solution {
    //重要程序排序，优先考虑代码正确，其次考虑效率，时间复杂度
    private static List<Integer> intArrayToList(int[] array) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i < array.length;i++) {
            list.add(array[i]);
        }

        return list;

    }


    public static boolean validateStackSequences(int[] pushed, int[] popped) {

        //吧两个数组实现为顺序表List
        List<Integer> pushList = intArrayToList(pushed);
        List<Integer> popList = intArrayToList(popped);


        //实现准备的栈
        Deque<Integer> stack = new LinkedList<>();
        //数组不能通过length判断是否为空， 是通过几个下标去判断，比较麻烦
        //所以建议大家使用List

        //while（只要pop还没有空）
        while (!popList.isEmpty()) {
            //取出popList 的第一个元素
            int p = popList.remove(0);


                //如果栈是空的或者栈顶元素不等于p
            while (stack.isEmpty() || stack.peek().intValue() != p) {
                    //判断pushList是都为空
                if(pushList.isEmpty()) {
                        return false;
                }

                //从pushList取出第一个元素
                int q = pushList.remove(0);
                //吧q压入栈中
                stack.push(q);
            }


            //弹出栈顶元素
            stack.pop();

        }
        return true;
    }

    public static void main(String[] args) {
        int[] pushed = {1,2,3,4,5};
        int[] popped = {4,3,5,1,2};

        System.out.println(validateStackSequences(pushed, popped));


    }
}
