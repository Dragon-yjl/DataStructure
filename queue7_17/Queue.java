package queue7_17;

import java.util.NoSuchElementException;

public interface Queue {

    //第一组方法
    //通过抛出异常，通知错误

    //插入
    //永远返回true
    default boolean add(Integer e) {
        if(offer(e) == false) {
            throw new IllegalStateException();
        }
        return true;
    }


    //检索队首元素，但不删除
    default Integer element() {
        Integer e = peek();
        if(e == null) {
            throw new NoSuchElementException();
        }
        return e;
    }

    ///返回并删除队首元素
    default Integer remove() {
        Integer e = poll();
        if(e == null) {
            throw new NoSuchElementException();
        }
        return e;
    }



    //第二组方法
    //通过特殊的返回值，通知错误

    //插入
    //永远返回true
    boolean offer(Integer e);


    //检索队首元素，但不删除
    //如果返回null  代表队列是空的
    Integer peek();


    //返回并删除队首元素
    //如果返回null，代表队列是空的
    Integer poll();
}
