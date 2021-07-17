package queue7_17;

import java.util.NoSuchElementException;


/**
 * Deque（双端队列）  分为FIFO 队列  add remove element
 * 和 FILO 栈  push pop  peek
 */
public interface Deque extends Queue {

    //第一组方法 通过特殊值报告错误

    boolean offerFirst(Integer e);

    Integer peekFirst();

    Integer pollFirst();

    boolean offerLast(Integer e);

    Integer peekLast();

    Integer pollLast();


    //第二组方法，通过异常报错

    default void addFirst(Integer e) {
        if(offerFirst(e) == false) {
            throw new IllegalStateException();
        }
    }

    default Integer getFirst() {
        Integer e = peekFirst();
        if( e == null) {
            throw new NoSuchElementException();
        }
        return e;
    }

    default Integer removeFirst() {
        Integer e = pollFirst();
        if(e == null) {
            throw new NoSuchElementException();
        }
        return e;
    }


    default void addLast(Integer e) {

        if(offerLast(e) == false) {
            throw new IllegalStateException();
        }
    }

    default Integer getLast() {
        Integer e = peekLast();
        if(e == null) {
            throw new NoSuchElementException();
        }
        return e;
    }

    default Integer removeLast() {
        Integer e = pollLast();
        if(e == null) {
            throw new NoSuchElementException();
        }
        return e;
    }


    //下面这组方法，继承自Queue
    //特殊值

    default boolean offer(Integer e) {
        return offerLast(e);
    }

    default Integer peek() {
        return peekFirst();
    }

    default Integer poll() {
        return pollFirst();
    }


    //下面这组方法为栈的形态做准备，还包括上面的peek方法

    default void push(Integer e) {
        addFirst(e);
    }

    default Integer pop() {
        return removeFirst();
    }
}
