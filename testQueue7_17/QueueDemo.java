package testQueue7_17;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {

    public static void main(String[] args) {

        Queue<String> queue = new LinkedList<>();

        //返回特殊值

        queue.offer("A");
        queue.offer("B");
        queue.offer("C");
        queue.offer("D");

        System.out.println(queue);//[A, B, C, D]

        System.out.println(queue.peek());//A
        //只是检索，并没有取走这个值
        System.out.println(queue.peek());//A

        System.out.println(queue.poll());//A
        System.out.println(queue.poll());//B
        System.out.println(queue.poll());//C
        System.out.println(queue.poll());//D
        System.out.println(queue.poll());//null




        //抛异常


//        queue.add("A");
//        queue.add("B");
//        queue.add("C");
//        queue.add("D");
//        queue.add("E");
//
//        System.out.println(queue);//[A, B, C, D, E]
//
//        System.out.println(queue.element());//A
//        //检索这个元素，并没有取走
//        System.out.println(queue.element());//A

//
//        System.out.println(queue.remove());///A
//        //检索这个元素并取走
//        System.out.println(queue.remove());//B
//        System.out.println(queue.remove());//C
//        System.out.println(queue.remove());//D
//        System.out.println(queue.remove());//E
//        System.out.println(queue.remove());
//        //java.util.NoSuchElementException

    }
}
