package LinkedList_0926;


import com.sun.xml.internal.bind.marshaller.NioEscapeHandler;

class Node {

    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }
}

public class MyLinkedList {

    public Node head;

    public void addFirst(int e) {

        Node node = new Node(e);
        if(this.head == null) {
            this.head = node;
        }else  {
            node.next = this.head;
            this.head = node;
        }
    }

    public void display() {

        Node cur = this.head;

        while (cur!= null) {
            System.out.print(cur.data +" ");
            cur = cur.next;
        }
        System.out.println();
    }

    public Node middleNode() {
        Node slow = this.head;
        Node fast = this.head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}
