package nowCoder_NC24;

public class Main {




        /**
         *
         * @param head ListNode类
         * @return ListNode类
         */
        public static ListNode deleteDuplicates (ListNode head) {
            // write code here
            ListNode tmp = new ListNode(-1);
            tmp.next = head;
            ListNode pre = tmp;
            ListNode cur = head;
            while(cur != null && cur.next != null) {
                if(cur.val != cur.next.val) {
                    pre = cur;
                    cur = cur.next;
                }else {
                    while(cur.next != null && cur.val==cur.next.val) {
                        cur = cur.next;
                    }
                    cur = cur.next;
                    pre.next = cur;
                }
            }
            return tmp.next;
        }

    public static void main(String[] args) {

            ListNode n1 = new ListNode(2);
            ListNode n2 = new ListNode(20);
            ListNode n3 = new ListNode(1);
            ListNode n4 = new ListNode(11);

            n1.next = n2;
            n2.next = n3;
            n3.next = n4;
        ListNode head = deleteDuplicates(n1);

        System.out.println(head.val );

    }
}

