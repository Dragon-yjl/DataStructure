package leetCode;

public class LinkedCopy {

    private Node head;

    //普通链表的复制
    public static Node copy(Node head) {
        if(head == null) {
            return null;
        }
        Node cur = head;

        Node newHead = new Node(-1);
        Node tmp = newHead;
        while (cur != null) {
            Node node = new Node(cur.val);
            tmp.next = node;
            tmp = node;

            cur = cur.next;

        }

        return newHead.next;
    }
}
