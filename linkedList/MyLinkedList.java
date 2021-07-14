package linkedList;

public class MyLinkedList implements List {

    public Node head; //指向第一个节点
    public Node last; //指向最后一个节点
    public int size;

    @Override
    //尾插法 O(1)
    public boolean add(Integer e) {
        Node node = new Node(e);
        //三种方式都可以判断链表为空
//        if(size == 0)
//        if(last == null)
        if(head == null) {

            this.head = node;
            this.last = node;

        }else {
            this.last.next = node;
            node.prev = this.last;
            this.last = node;

        }
        size++;
        return true;
    }

    @Override
    //下标插法 O（n）
    public void add(int index, Integer e) {

        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException("下标越界："+index);
        }

        Node node = new Node(e);
        ///先尾插就不用再头插法中考虑头结点为空的情况
        if(index == size) {//尾插

            add(e);
        }else if(index == 0) {//头插法
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
            size++;
        }else {//其他插入情况
            //找到index-1所在的位置，进行节点插入
            //prev要走index- 1步
            Node prev;
            if(index - 1 < size/2) {
                prev = this.head;
                //从head处出发，找到index- 1位置的节点
                for(int i = 0;i < index - 1;i++) {
                    prev = prev.next;
                }
            }else {//prev 走size-1 - (index - 1)步
                //从last处出发，找到index-1位置的节点
                prev = last;
                for(int i =0;i<size - index;i++) {
                    prev = prev.prev;
                }

            }
            //走到这里，prev指向index-1位置的下标
            Node next = prev.next;//记录next 为index位置节点
            node.prev = prev;//要插入节点的前驱指向index- 1位置节点
            node.next = next;//要插入节点的下一个节点指向index位置节点

            prev.next = node;//index-1 位置的节点的下一个节点指向要插入的节点
            next.prev = node;//index位置的节点的前驱指向要插入的节点

            size++;

        }

    }

    @Override
    //下标删除 O（n）
    public Integer remove(int index) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException("下标越界："+index);
        }

        //走到这里，size一定是>0的

        Integer v;
        if(index == 0) {//删除的是头节点
            v = head.element;
            this.head = this.head.next;//头结点指向头结点的下一个节点
            this.head.prev = null;//t头结点的前驱为空
            size--;
            if(size == 0) {//删除完之后如果链表为空
                last = null;
            }

        }else if(index == size-1) {//删除的是尾结点
            v = last.element;
            this.last = this.last.prev;//尾结点指向前一个节点
            this.last.next = null;//尾结点的下一个节点指向空
            size--;
            if(size ==0) {
                head = null;
            }

        }else {
            //找到index-1所在的位置，进行节点删除
            //prev要走index- 1步
            Node prev;
            if(index - 1 < size/2) {
                prev = this.head;
                //从head处出发，找到index- 1位置的节点
                for(int i = 0;i < index - 1;i++) {
                    prev = prev.next;
                }
            }else {//prev 走size-1 - (index - 1)步
                //从last处出发，找到index-1位置的节点
                prev = last;
                for(int i =0;i<size - index;i++) {
                    prev = prev.prev;
                }

            }
            //走到这里，prev指向index-1位置的下标
            Node tpRemove = prev.next;//记录要删除的节点
            v = tpRemove.element;
            prev.next = tpRemove.next;//index-1位置的节点的next指向要删除的节点的next
            tpRemove.next.prev = prev;//要删除的节点的下一个节点的前驱指向找到的index-1节点
            size--;

        }

        return v;
    }

    @Override
    //元素删除法 0(n)
    public boolean remove(Integer e) {

        Node prev = null;
        for(Node cur = this.head; cur != null; prev = cur, cur = cur.next) {
            if(cur.element.equals(e)){
                if(prev == null) {
                    remove(0);
                    size--;
                    return true;
                }else {
                    prev.next.next.prev = prev;//要删除的下一个节点的前驱指向要删除的上一个节点
                    prev.next = prev.next.next;//要删除的前一个节点的next指向要删除的下一个节点
                    size--;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    //获取制定下标位置的值 O(n)
    public Integer get(int index) {

        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException("下标越界："+index);
        }

        Node cur = head;
        for(int i = 0;i < index;i++) {
            cur = cur.next;
        }

        return cur.element;
    }

    @Override
    //给指定的下标位置赋值 O（n）
    public Integer set(int index, Integer e) {

        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException("下标越界："+index);
        }

        Node cur = head;
        for(int i = 0;i < index;i++) {
            cur = cur.next;
        }

        Integer v = cur.element;
        cur.element = e;
        return v;
    }

    @Override
    //O(1)
    public int size() {
        return size;
    }

    @Override
    //O(1)  不内存泄漏   其实是O(n)
    public void clear() {

        head = null;
        last = null;
        size = 0;
    }

    @Override
    //O(1)
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    //判断链表中有没有这个值O(n)
    public boolean contains(Integer e) {
        return indexOf(e) != -1;
    }

    @Override
    //找出给出元素第一次出现的下标 O（n）
    public int indexOf(Integer e) {

        int i =0;
        for(Node cur =head; cur != null; cur = cur.next,i++) {
            if(cur.element.equals(e)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    //找出给定元素最后一次出现的下标O（n）
    public int lastIndexOf(Integer e) {

        int i = size-1;
        for(Node cur = last; cur != null;cur = cur.prev,i--) {
            if(cur.element.equals(e)) {
                return i;
            }
        }


        return -1;
    }

    @Override
    public LinkedListIterator iterator() {
        return new LinkedListIterator(this);
    }

    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder("[");
       for(Node cur = head; cur != null; cur = cur.next) {
           sb.append(cur.element);
           if(cur != last) {
               sb.append(", ");
           }
       }
       sb.append("]");
       return sb.toString();
    }
}
