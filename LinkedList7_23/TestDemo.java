package LinkedList7_23;

public class TestDemo {

    Node head;

    //头插法
    public static Node addFirst(Node head,int e) {

        Node node = new Node(e);

        if(head == null) {
            head = node;
        }else {
            node.next = head;
            head = node;
        }
        return head;
    }

    //尾插法
    public static Node addLast(Node head,int e) {

        Node node = new Node(e);

        if(head == null) {
            head = node;
        }else {
            Node cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
        return head;
    }


    //头删法
    public static Node removeFirst(Node head) {
        if(head == null) {
            return null;
        }else {
            head = head.next;
        }

        return head;
    }

    //尾删法
    public static Node removeLast(Node head) {

        if(head == null) {
            return null;
        }else {
            Node cur = head;
            while (cur.next.next != null) {
                cur = cur.next;
            }
            //cur 现在是倒数第二个节点
            cur.next = null;

        }
        return head;
    }


    public static void disPlay(Node head) {
        Node cur = head;
        while (cur!= null) {
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
    }

    public static void main(String[] args) {

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        n1.next = n2;
        n1.next.next = n3;
        n1.next.next.next = n4;


//        Node head = addFirst(n1, 0);
//
//        disPlay(head); // 0 1 2 3 4
//
//        Node newNode  = addLast(n1, 5);
//
//        disPlay(newNode);// 1 2 3 4 5
//

//        Node node = removeFirst(n1);
//
//        disPlay(node);//2 3 4

        Node node = removeLast(n1);
        disPlay(node);//1 2 3
    }
}
