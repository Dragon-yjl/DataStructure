package bracket7_18;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner sca = new Scanner(System.in);

        String s = sca.nextLine();

        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        //1.准备好一个放Character 类型的栈
        Deque<Character> stack = new LinkedList<>();

        //2.遍历s的每一个字符

        //第一种方式
//        for(int i = 0;i<s.length();i++) {
//            char c = s.charAt(i);
//        }

        //第二种方式

        char[] charArray = s.toCharArray();
        for(char c : charArray) {

            switch (c) {
                case'(':
                case '[':
                case'{':
                    //因为没有break 所以，无论（ [ { 都会执行、
                    stack.push(c);
                    break;
                default: {
                    //一定是右括号
                    if(stack.isEmpty()) {
                        //右括号多了
                        return false;
                    }

                    //否则取出栈顶元素
                    char left = stack.pop();
                    //进行左右括号的比较
                    if(!compareBracket(left,c)) {
                        //左右括号不匹配
                        return false;
                    }
                }
            }
        }
        if(stack.isEmpty()) {
            return true;
        }else {
            //左括号多了
            return false;
        }
    }

    public static boolean compareBracket(char left,char right) {
        if(left == '(' && right == ')') {
            return true;
        }
        if(left == '[' && right == ']') {
            return true;
        }
        if(left == '{' && right == '}') {
            return true;
        }

        return false;
    }
}
