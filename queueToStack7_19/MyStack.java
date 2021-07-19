package queueToStack7_19;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 用FIFO 的队列 A B C D  转换为FILO的栈
 * 思想 拿出一个放进去，在哪一个再放进去
 */
public class MyStack {
    /** Initialize your data structure here. */

    private  Queue<Integer>  queue;

    public MyStack() {
        queue = new LinkedList<>();
    }



    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);

    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int size = queue.size();
        for(int i = 0;i < size - 1;i++) {
            Integer e  = queue.remove();
            queue.add(e);
        }

        return queue.remove();

    }

    /** Get the top element. */
    public int top() {

        int size = queue.size();
        for(int i = 0;i < size-1 ; i++) {
            Integer e = queue.remove();
            queue.add(e);
        }
        Integer t = queue.remove();
        queue.add(t);
        return t;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {

        return queue.isEmpty();
    }

    public static void main(String[] args) {

     MyStack stack = new MyStack();

     stack.push(1);
     stack.push(2);
     stack.push(3);
     stack.push(4);

     System.out.println(stack);

     stack.pop();

        System.out.println(stack);

        stack.top();

        System.out.println(stack);

        System.out.println(stack.empty());

    }

}
