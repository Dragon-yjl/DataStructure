package nowCoder_0729;

import javax.swing.*;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    //找出键盘上坏的键,按照发现错误的顺序输出
    public static void main(String[] args) {

        //1.读取实际输入和看到的字符串
        Scanner scan = new Scanner(System.in);
        String IntPut = scan.nextLine();
        String SeePut = scan.nextLine();

        //2.为了方便比较，将所有字符转化为大写
        IntPut = IntPut.toUpperCase();
        SeePut = SeePut.toUpperCase();

        //3.将看到的字符串建立一个set集合（方便查找—— 提高查找时间复杂度）
        Set<Character> seeSet = new TreeSet<>();
        for(char see : SeePut.toCharArray()) {
            seeSet.add(see);
        }

        //4.准备一个错误按键的Set集合（用于去重）
        Set<Character> errorSet = new TreeSet<>();


        //5.遍历实际输入的每个字符 如果没有在看到的字符串中，就是一个错误按键

        for(char in : IntPut.toCharArray()) {
            if(!seeSet.contains(in)) {//不包含说明这个键是错误的
                if(!errorSet.contains(in)) {//说明是刚发现的一个错误按键
                    //6.这里输出就能保证实际输入的顺序是按照发现错误的顺序进行的
                    System.out.print(in);

                }

                errorSet.add(in);
            }
        }

        //6.输出错误按键

//        //输出顺序不对，
//        for(char put : errorSet) {
//            System.out.print(put);
//        }
//        System.out.println();

    }
}
