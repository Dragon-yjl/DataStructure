package queueDemo0717;

import java.util.Deque;
import java.util.LinkedList;

public class TestDeque {

    public static void main(String[] args) {

        Deque<Integer> deque = new LinkedList<>();

        deque.add(1);
        deque.add(2);
        deque.add(3);
        deque.add(4);
        deque.add(5);

        System.out.println(deque);///[1, 2, 3, 4, 5]


        System.out.println(deque.removeLast());///5
        System.out.println(deque.removeLast());//4
        System.out.println(deque.removeFirst());//1

        System.out.println(deque);///[2, 3]
    }
}
