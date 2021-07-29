package leetCode;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Solution {

    //带有随机指针的链表的赋值
    public Node copyRandomList(Node head) {
        //1.通过遍历老链表， 复制新的链表（让random指向老链表的节点）

        ///同时 记录一个映射关系（老街店--》新节点）
        Map<Node,Node> map = new TreeMap<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.hashCode() - o2.hashCode();
            }
        });

        Node newHead = new Node(-1);
        Node tmp = newHead;

        Node cur = head;
        while (cur != null) {
            Node node = new Node(cur.val);

            tmp.next = node;
            tmp = node;

            ///建立映射关系
            map.put(cur,node);

            cur = cur.next;
        }

        //到这里老链表的普通节点已经复制完毕 且新链表的头结点是newHead.next

        //2.专心处理random的指向关系
        //定义一个oldCur 指向老链表的头结点
        Node oldCur = head;
        //定义一个newCur指向新链表的头结点
        Node newCur = newHead.next;
        while (oldCur != null) {
            //定义一个oldRandom指向老链表中的随机指针
            Node oldRandom = oldCur.random;
            //定义一个newRandom指向新链表中的随机指针
            Node newRandom;
            if(oldRandom == null) {
                newRandom = null;
            }else {
                newRandom = map.get(oldRandom);
            }

            newCur.random = newRandom;

            oldCur = oldCur.next;
            newCur = newCur.next;
        }

        return newHead.next;
    }
}
