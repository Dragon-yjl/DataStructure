package queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {

    public static void main(String[] args) {

        Queue<String> queue = new LinkedList<>();

        queue.offer("A");
        queue.offer("B");
        queue.offer("C");
        queue.offer("D");

        System.out.println(queue.peek());//A 只是检索，并没有取走这个值
        System.out.println(queue.peek());//A

        System.out.println(queue.poll());//A检索并取走了这个值
        System.out.println(queue.poll());//B
        System.out.println(queue.poll());//C
        System.out.println(queue.poll());//D
        System.out.println(queue.poll());//null
//
//        queue.add("A");
//        queue.add("B");
//        queue.add("C");
//        queue.add("D");
//
//        System.out.println(queue.element());//A
//        //z只是检索这个值，并没有取走
//        System.out.println(queue.element());//A
//
//        System.out.println(queue.remove());//A
//        //检索这个值并取走
//        System.out.println(queue.remove());//B
//        System.out.println(queue.remove());//C
//        System.out.println(queue.remove());//D
//        System.out.println(queue.remove());//NoSuchElementException
    }
}
