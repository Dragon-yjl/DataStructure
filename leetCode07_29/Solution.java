package leetCode07_29;

public class Solution {

    private Node head;
    //方法二 复制链表
    public static Node copyLinked(Node head) {
        if(head == null) {
            return null;
        }

        //让老链表123的每个节点指向新链表abc的每个节点1->a->2->b->3->c

        Node cur = head;
        while (cur != null) {
            Node node = new Node(cur.val);
            Node curNext = cur.next;//老链表的下一个节点保存下来
            cur.next = node;//让老链表的当前节点的下一个节点指向新链表的节点
            node.next = curNext;//再让新链表的节点指向老链表的下一个节点
            cur = curNext;

        }
        //到这新老链表就都串起来了

        //遍历合并起来的链表并且处理random的指向
        Node oldCur = head;
        while (oldCur != null) {

            Node newCur = oldCur.next;//新链表的cur

            //处理random
            if(oldCur.random != null) {
                newCur.random = oldCur.random.next;
            }

            oldCur = oldCur.next.next;//老链表的cur
        }

        //下面是让新老链表分开指向，老链表指向老节点
        oldCur = head;
        Node newHead = head.next;
        while (oldCur != null) {
            //让新链表的cur指向老链表的下一个
            Node newCur = oldCur.next;

            oldCur.next = newCur.next;
            if(newCur.next != null) {
                newCur.next = newCur.next.next;
            }

            oldCur  = oldCur.next;


        }

        return newHead;

    }

}
