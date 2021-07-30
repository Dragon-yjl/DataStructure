package nowCoder7_30;

import java.util.Scanner;

//牛客网学生成绩输入与输出
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] arr = new int[3];
        for(int i = 0; i < arr.length;i++) {
            arr[i] = scan.nextInt();
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print("score"+(i+1)+"="+arr[i]+",");
        }


    }
}