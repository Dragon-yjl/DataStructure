package LinkedList_0926;

public class MyLinkedTest {

    public static void main(String[] args) {

        MyLinkedList list = new MyLinkedList();

        //list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);
        list.addFirst(40);
        list.addFirst(50);
        list.addFirst(60);

        list.display();

        Node node = list.middleNode();
        System.out.println(node.data);
    }
}
