package testQueue7_17;

import java.util.Deque;
import java.util.LinkedList;

public class DequeDemo {

    public static void main(String[] args) {

        Deque<Integer> deque = new LinkedList<>();

        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        deque.addLast(7);
        deque.addLast(8);
        deque.addLast(9);


        System.out.println(deque);
        //[3, 2, 1, 7, 8, 9]

        while (!deque.isEmpty()) {
            if(!deque.isEmpty()) {
                System.out.println(deque.getFirst());
            }
            if(!deque.isEmpty()) {
                System.out.println(deque.removeFirst());
            }
            if(!deque.isEmpty()) {
                System.out.println(deque.getLast());
            }
            if(!deque.isEmpty()) {
                System.out.println(deque.removeLast());
            }
        }

        //循环结束之后运行结果为3 3  9 9 2 2  8 8 1 1 7 7
    }
}
