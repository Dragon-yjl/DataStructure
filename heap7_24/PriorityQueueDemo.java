package heap7_24;

import java.util.PriorityQueue;

public class PriorityQueueDemo {


    public static void main(String[] args) {
        PriorityQueue<Person> queue = new PriorityQueue<>();

        Person p1 = new Person(18,"高博");
        Person p2 = new Person(22,"cpx");
        Person p3 = new Person(30,"汤众");
        Person p4 = new Person(16,"徐志成");


        queue.add(p1);
        queue.add(p2);
        queue.add(p3);
        queue.add(p4);

        System.out.println(queue.remove());
    }

    public static void main1(String[] args) {

        //jdk实现
        //PriorityQueue<Integer> queue = new PriorityQueue<>();

        //自己实现
        MyPriorityQueue queue = new MyPriorityQueue();

        queue.add(3);
        queue.add(5);
        queue.add(2);
        queue.add(7);

        //按堆的特点插入 所以先打印2
        //优先级队列内部是以堆实现的
        System.out.println(queue.remove());//2
        System.out.println(queue.remove());//3
        System.out.println(queue.remove());//5
        System.out.println(queue.remove());//7
    }
}
