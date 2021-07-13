package linkedList;

import java.util.LinkedList;

public class MyArrayTest {

    public static void main(String[] args) {

        List list = new MyLinkedList();

        list.add(0,999);
        list.add(31);
        list.add(32);
        list.add(33);
        System.out.println(list);//[999, 31, 32, 33]

        list.add(0,10000);

        System.out.println(list);//[10000, 999, 31, 32, 33]
        list.add(5,666);
        System.out.println(list);//[10000, 999, 31, 32, 33, 666]

        list.add(2,88);
        System.out.println(list);//[10000, 999, 88, 31, 32, 33, 666]

        list.add(4,66);
        System.out.println(list);//[10000, 999, 88, 31, 66, 32, 33, 666]
    }
}
