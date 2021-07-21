package binaryTree07_22;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树层序遍历 打印节点的层数和节点的值
 *
 */

public class TreeLevelOrder {

    //用来打包层次和节点的
    static class NL{
        TreeNode node;
        int level;

        public NL(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public static void  levelOrderWithLevel(TreeNode root) {
        if(root == null) {
            return;
        }

        //定义一个队列里面存放得是打包的层次根节点NL
        Queue<NL> queue = new LinkedList<>();
        //吧根节点 和 1 代表第一层 放入队列中
        queue.add(new NL(root,1));

        while (!queue.isEmpty()) {
            //把放进去的节点和层数取出来
            NL nl = queue.remove();
            TreeNode node = nl.node;
            int level = nl.level;

            //打印层数和节点
            System.out.print(level+" ");
            System.out.print(node.v);
            System.out.println();

            //然后判断左孩子不为空的时候吧左孩子的节点和层数放进队列
            if(node.left != null) {
                queue.add(new NL(node.left,level+1));
            }

            //然后判断左孩子不为空的时候吧左孩子的节点和层数放进队列
            if(node.right != null) {
                queue.add(new NL(node.right,level+1));
            }
        }

    }

    public static void main(String[] args) {

        TreeNode root = BuildTree.buildTree1();

        levelOrderWithLevel(root);
    }
}
