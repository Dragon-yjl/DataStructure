package stack7_19;

import java.util.Deque;
import java.util.LinkedList;

public class MinStack {

    private Deque<Integer> s1;//普通栈
    private Deque<Integer> s2;//最小栈

    @Override
    public String toString() {
        return "MinStack{" +
                "s1=" + s1 +
                ", s2=" + s2 +
                '}';
    }

    public MinStack() {
        s1 = new LinkedList<>();
        s2 = new LinkedList<>();
    }

    public void push(int val) {
        s1.push(val);//先把元素压入普通栈
        if(s2.isEmpty()) {
            s2.push(val);//如果最小栈是空的，吧元素压入最小栈
        }else {
            int t = s2.peek();//保存最小栈的栈顶元素
            if(val < t) {
                s2.push(val);//如果要放入的元素小于最小栈栈顶元素，则把该元素压入最小栈
            } else {
                s2.push(t);//如果该元素大于最小栈栈顶元素，则把最小栈栈顶元素再次压入最小栈
            }
        }
    }

    public void pop() {
        // 两个栈栈顶元素都出栈
        s1.pop();
        s2.pop();
    }

    public int top() {
        //返回普通栈栈顶元素
        return s1.peek();

    }

    public int getMin() {
        //返回最小栈的栈顶元素
        return s2.peek();

    }

    public static void main(String[] args) {

        MinStack minStack = new MinStack();

        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        System.out.println(minStack);
        //MinStack{s1=[-3, 0, -2], s2=[-3, -2, -2]}

        System.out.println(minStack.getMin());//-3

        minStack.pop();

        System.out.println(minStack.top());//0

        System.out.println(minStack.getMin());//-2

    }
}
