package Test7_26;

import java.util.Scanner;

//该字符构成的三角形金字塔
public class Pyramid {

    public static void pyramid (int  n) {

        //外层n控制层数
    for(int i =1;i <=5;i++){
        for(int j = 1;j <= 5-i;j++) {
            //打印空格
            System.out.print(" ");

        }
        for(int k = 1;k <= i;k++) {
            System.out.print(n+" ");
        }
        System.out.println();
    }

    }

    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);

        int  n =  sca.nextInt();

        pyramid(n);

    }
}
