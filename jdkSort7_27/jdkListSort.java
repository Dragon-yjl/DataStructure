package jdkSort7_27;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//使用jdk中list排序方式
public class jdkListSort {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(9);
        list.add(5);
        list.add(4);
        list.add(7);
        list.add(3);
        list.add(2);
        list.add(9);
        list.add(1);

        System.out.println(list);

        //法一
        Collections.sort(list);

        //法二
//        list.sort(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1-o2;
//            }
//        });

        System.out.println(list);
    }

}
