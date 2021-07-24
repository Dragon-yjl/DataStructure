package LeetCode7_24;

public class TestDemo {

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

    //十六进制的ABCDEF 转换为10进制
    public static void main(String[] args) {

        long n = 10 * pow(16,5) + 11 * pow(16,4)
        + 12 * pow(16,3) + 13 * pow(16,2)
        + 14 * pow(16,1) + 15 * pow(16,0);

        System.out.printf("%15d\n",n);
    }
}
