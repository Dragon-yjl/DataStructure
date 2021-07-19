package linkedList7_19;

public class MyLinkedList implements Deque {

    private static class Node {

        private Integer val;
        Node prev;
        Node next;

        public Node(Integer val) {
            this.val = val;
        }
    }


    public Node head;
    public Node tail;
    public int size;

    @Override
    //头插法·
    public boolean offerFirst(Integer e) {
        Node node = new Node(e);
        if(size == 0 ) {
            head = tail =  node;
        }else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
        return true;
    }

    @Override
    //获取头结点
    public Integer peekFirst() {
        if(size == 0) {
            return null;
        }
        return head.val;
    }

    @Override
    //获取头结点并删除
    public Integer pollFirst() {
        if(size == 0) {
            return null;
        }

        Integer e = head.val;
        head = head.next;
        if(head != null) {
            head.prev = null;
        }else {
            tail = null;
        }
        size--;
        return e;
    }

    @Override
    //尾插法
    public boolean offerLast(Integer e) {
        Node node = new Node(e);
        if(size == 0) {
            tail = head = node;
        }else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
        return true;
    }

    @Override
    //获取尾部节点
    public Integer peekLast() {
        if(size == 0) {
            return null;
        }

        return tail.val;
    }

    @Override
    //获取并删除尾部节点
    public Integer pollLast() {
        if(size == 0) {
            return null;
        }

        Integer e = tail.val;
        tail = tail.prev;
        if(tail != null) {
            tail.next = null;
        }else {
            head = null;
        }
        size --;
        return e;
    }
}
