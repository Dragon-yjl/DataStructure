package nowCoder0_70;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        //str.substring方法分割字符串 左闭右开
        System.out.printf("year="+ str.substring(0,4)+"\n"+"month="+str.substring(4,6)
                +"\n"+"date="+ str.substring(6,8));
    }
}

