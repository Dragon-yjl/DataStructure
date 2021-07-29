package leetCode;

public class TestCase {

    public static void main(String[] args) {

        Node n1 = new Node(3);
        Node n2 = new Node(9);
        Node n3 = new Node(1);
        Node n4 = new Node(6);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
//
//        LinkedCopy linkedCopy = new LinkedCopy();
//        Node node = linkedCopy.copy(n1);

        n2.random = n1;

        Solution solution = new Solution();
        Node node = solution.copyRandomList(n1);

        while (node != null) {
            System.out.println(node.val);

            System.out.println(node.random);
            node = node.next;
        }
    }
}
