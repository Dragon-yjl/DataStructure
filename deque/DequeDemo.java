package deque;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Deque 继承Queue 所以 Queue 中有的方法 Deque中也有
 */
public class DequeDemo {

    public static void main(String[] args) {

        Deque<Integer> deque = new LinkedList<>();

        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        deque.addFirst(4);
        deque.addLast(5);
        deque.addLast(6);
        deque.addLast(7);

        System.out.println(deque);//[4, 3, 2, 1, 5, 6, 7]



        while (!deque.isEmpty()) {
            if(!deque.isEmpty())  {
                System.out.println(deque.getFirst());//第一次循环4 第二次 3  第三次  2 第四次  1
            }
            if(!deque.isEmpty()) {
                System.out.println(deque.removeFirst());//4  3  2  1
            }
            if(!deque.isEmpty()) {
                System.out.println(deque.getLast());//7  6  5
            }
            if(!deque.isEmpty()) {
                System.out.println(deque.removeLast());//7  6  5
            }
        }
    }
}
