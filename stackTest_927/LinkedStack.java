package stackTest_927;

/**
 * 链表实现栈
 *
 * @param <T>
 */

class Mystack<T> {
    //定义链表
    class Node<T> {
        private T t;
        private Node next;
    }

    private Node<T> head;

    //构造函数初始化头指针
    Mystack() {
        head = null;
    }

    //入栈
    public void push(T t) {
        if (t == null) {
            throw new NullPointerException("参数不能为空");
        }
        if (head == null) {
            head = new Node<T>();
            head.t = t;
            head.next = null;
        } else {
            Node<T> temp = head;
            head = new Node<>();
            head.t = t;
            head.next = temp;
        }
    }

    //出栈
    public T pop() {
        T t = head.t;
        head = head.next;
        return t;
    }

    //栈顶元素
    public T peek() {
        T t = head.t;
        return t;
    }

    //栈空
    public boolean isEmpty() {
        if (head == null)
            return true;
        else
            return false;
    }
}

public class LinkedStack {
    public static void main(String[] args) {
        Mystack stack = new Mystack();
        System.out.println(stack.isEmpty());//true
        stack.push("Java");
        stack.push("is");
        stack.push("beautiful");
        System.out.println(stack.peek());//beautiful
        System.out.println(stack.peek());//beautiful
        System.out.println(stack.pop());//beautiful
        System.out.println(stack.pop());//is
        System.out.println(stack.isEmpty());//false
        System.out.println(stack.pop());//java
        System.out.println(stack.isEmpty());//true
    }

}