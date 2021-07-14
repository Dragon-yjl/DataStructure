package yanghui;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static List<List<Integer>> generate(int numRows) {

        //最外层一定是List
        List<List<Integer>> outerList = new ArrayList<>();
        //最外层的List

        for(int i = 0;i < numRows; i++) {//表示有多少行
            List <Integer> elementList = new ArrayList<>();
            //内层元素List 表示每一行有多少个元素

            for(int j = 0;j <= i; j++) {//表示每一行有多少列
                elementList.add(1);

            }

            outerList.add(elementList);
        }
        //走到这一步，基本框架构造成功，里面全是1

        for(int i =2; i < outerList.size(); i++) {//表示从第三行开始
            List<Integer> elementList = outerList.get(i);

            for(int j = 1; j < elementList.size()-1; j++) {//表示从第三行第二个数字开始到最后倒数第二个数字
                //把上一行要用的两个数字记下来
                int a = outerList.get(i-1).get(j-1);
                int b = outerList.get(i-1).get(j);

                elementList.set(j,a+b);
            }

        }
        return outerList;
    }

    public static void main(String[] args) {

        for(List<Integer>  list : generate(10)) {
            System.out.println(list);
        }

    }
}
