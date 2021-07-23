package lesson7_23;

import java.util.Deque;
import java.util.LinkedList;

public class NonRecursion {

    //非递归前序遍历
    public static void preOrder(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;

        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                System.out.println(cur.v);

                stack.push(cur);
                cur = cur.left;
            }

            //走到这里 左子树遍历完了
             //把栈顶元素就是根节去掉
            TreeNode top = stack.pop();
            cur = top.right;
        }
    }

    //非递归中序遍历
    public static void inOrder(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;

        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {

                stack.push(cur);
                cur = cur.left;
            }

            //走到这里 左子树遍历完了
            //把栈顶元素就是根节去掉
            TreeNode top = stack.pop();
            //这里就是表示第三次经过该节点
            //中序遍历从栈里取出来的时候打印
            System.out.println(top.v);
            cur = top.right;
        }
    }


    //非递归后序遍历
    public static void postOrder(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();

        TreeNode cur = root;
        TreeNode last = null;//记录上次遍历的节点

        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {

                //cur  第一次经过这个节点
                //从根上parent 过来的
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode top = stack.peek();
            //取出栈顶元素 但是不删除
            if(top.right == null) {
                //实际上是第二次top 进过这个节点
                ///但是又因为右子树为空  可以看做是第三次经过节点
                //从左子树回来的 但是因为右子树为空 可以看做是从右子树回来的

                stack.pop();
                last = top;//last表示上一次经过的节点 已经经过三次了
                System.out.println(top.v);
            } else if(top.right == last) {
                //top 第三次经过节点
                //说明从右子树回来
                stack.pop();
                last = top;
                System.out.println(top.v);
            }else  {
                //top 第二次经过
                //说明从左子树回来的
                cur = top.right;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;

        preOrder(n1);
    }
}
