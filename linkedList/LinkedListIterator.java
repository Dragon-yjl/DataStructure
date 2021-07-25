package linkedList;

import java.util.LinkedList;

public class LinkedListIterator implements  Iterator{

    private MyLinkedList list;
    private Node cur;

    public LinkedListIterator(MyLinkedList list) {
        this.list = list;
        this.cur = list.head;
    }


    @Override
    public boolean hasNext() {
        return cur != null;
    }

    @Override
    public Integer next() {
        Integer e = cur.element;
        cur = cur.next;
        return e;
    }
}
