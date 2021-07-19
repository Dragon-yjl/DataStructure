package stackToQueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 用栈实现队列，1234 -> 1234
 * 思想：定义两个栈，入栈的时候直接放入第一个栈
 * 出栈的时候判断第二个栈是否为空，为空吧第一个栈元素全部
 * 压入第二个栈，不为空直接出栈
 */
public class MyQueue {

    private Deque<Integer> s1;
    private Deque<Integer> s2;

    @Override
    public String toString() {
        return "MyQueue{" +
                "s1=" + s1 +
                ", s2=" + s2 +
                '}';
    }

    public MyQueue() {

        s1 = new LinkedList<>();//第二个栈负责出栈
        s2 = new LinkedList<>();//第一个栈负责入栈
    }

    /** Push element x to the back of queue. */
    public void push(int x) {

        s2.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {

        if(s1.isEmpty()) {
            while (!s2.isEmpty()) {
                //把s2所有元素压入s1
                Integer e = s2.pop();
                s1.push(e);
            }
        }
        return s1.pop();

    }

    /** Get the front element. */
    public int peek() {

        if(s1.isEmpty()) {
            while (!s2.isEmpty()) {
                //把s2所有元素压入s1
                Integer e = s2.pop();
                s1.push(e);
            }
        }
        return s1.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();

    }

    public static void main(String[] args) {

        MyQueue myQueue = new MyQueue();

        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.push(4);
        System.out.println(myQueue);

        System.out.println(myQueue.peek());
        System.out.println(myQueue);

        System.out.println(myQueue.pop());


    }
}
