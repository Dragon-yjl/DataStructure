package binaryTree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class TestDemo {

    //二叉树求深度
    public  static int getHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = getHeight(root.left);
        int right = getHeight(root.right);


        return Math.max(left,right) + 1;
    }


    public static void levelOrder(TreeNode root) {

        if(root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {

            TreeNode node = queue.remove();

            System.out.print(node.val + " ");

            if(node.left != null) {
                queue.add(node.left);
            }


            if(node.right != null) {
                queue.add(node.right);
            }

        }
    }

    public static void main(String[] args) {

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;

        n3.right = n5;

        int height = getHeight(n1);

        System.out.println(height);

        levelOrder(n1);
    }
}
