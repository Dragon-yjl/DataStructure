package Test7_26;

import java.util.*;

public class Demo {

    /**
     * 把一个数放进数组中
     * @param n 输入一个数 n>=0
     * @return  返回一个数组
     */
    public static int[] digitToArray(long n) {

        Deque<Integer> stack = new LinkedList<>();


        //先%10 取出最后一位 在/10 把最后一位干掉
        while (n > 0) {
            int t = (int) (n % 10);
            stack.push(t);
            n = n / 10;

        }

        int[] array = new int[stack.size()];
        for(int i = 0;i < array.length;i++) {
            array[i] =stack.pop();
        }

        return array;

    }

    public static void main(String[] args) {

        Scanner sca = new Scanner(System.in);
        while (sca.hasNextLong()) {
            long n = sca.nextLong();


            System.out.println(Arrays.toString(digitToArray(n)));
        }
    }
}
