package LeetCode7_24;

import java.util.Scanner;

public class HexDemo {

    /**
     * 求 n 的 p 次方
     * @param n 输入一个n
     * @param p  输入一个p
     * @return  求 n 的 p 次方
     */
    public static long pow(int n, int p ) {
        long r = 1;
        for(int i = 0;i < p;i++) {
            r *= n;
        }

        return r;
    }

    private static int charToDigit(char c) {

        if(c > '0' && c < '9') {
            //ASCII 中'0' - '9' 是连续的
            //ASCII 码表中‘0’ 指的是数字48 所以48 - 48 才是数字0
            return c - '0';
        }else {//到这就是ABCDEF  再减去'A'表示数字0 1 2 在加上10就表示十进制的十几了

            return c - 'A' + 10;
        }

    }


    public static long hetToDec( String hexString) {

        //先把字符串转成字符数组
        char[] chars = hexString.toCharArray();
        long r = 0;
        for(char c : chars) {
        //首先把字符c 转成[0-15]的数字 原先里面有ABCDEF
            int digit = charToDigit(c);

            r = (r+digit) * 16;//这样多乘了一个16
        }


        return r/16;
    }




    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (scan.hasNextLine()) {
            String hexString = scan.nextLine();

            long n = hetToDec(hexString);

            System.out.println(n);
        }

    }
}


